package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShopService {

    private ProductRepo productRepo;
    private OrderRepo orderRepo;

    public ShopService(ProductRepo productRepo, OrderRepo orderRepo) {
        this.productRepo = productRepo;
        this.orderRepo = orderRepo;
    }

    public  void addOrder(int orderId , Map<Integer, Integer> productsIds){

        Map<Product,Integer> products = new HashMap<>();
        for (Map.Entry<Integer, Integer> entry : productsIds.entrySet()){
            int productId = entry.getKey();
            int quantity = entry.getValue();

            Product product = productRepo.getById(productId);
            if (product == null){
                System.out.println("Product with ID" + productId + "not Found");
                return;
            }
            products.put(product, quantity);
        }
        Order order = new Order(orderId, products, OrderStatus.PROCESSING);
        orderRepo.add(order);
    }
}
