package org.example;

import lombok.RequiredArgsConstructor;

import java.time.Instant;
import java.util.*;

@RequiredArgsConstructor
public class ShopService {

    private final ProductRepo productRepo;
    private final OrderRepo orderRepo;

//    public ShopService(ProductRepo productRepo, OrderRepo orderRepo) {
//        this.productRepo = productRepo;
//        this.orderRepo = orderRepo;
//    }

    public  void addOrder(int orderId , Map<Integer, Integer> productsIds){

        Map<Product,Integer> products = new HashMap<>();
        for (Map.Entry<Integer, Integer> entry : productsIds.entrySet()){
            int productId = entry.getKey();
            int quantity = entry.getValue();

            Product product = productRepo.getById(productId)
                    .orElseThrow(() -> new RuntimeException("Product with ID" + productId + "not Found"));

            products.put(product, quantity);
        }
        Order order = new Order(orderId, products, OrderStatus.PROCESSING, Instant.now());
        orderRepo.add(order);
    }
    public List<Order> getOrdersByStatus(OrderStatus  status){
        return  orderRepo.getAll().stream().filter(order -> order.orderStatus() == status)
                .toList();
    }

    public void updateOrder(int orderId , OrderStatus newStatus){
        Order order = orderRepo.getById(orderId);

        Order updatedOrder = order.withOrderStatus(newStatus);

        order.withOrderStatus(OrderStatus.IN_DELIVERY);

        orderRepo.add(updatedOrder);
    }

}
