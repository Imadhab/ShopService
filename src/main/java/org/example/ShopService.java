package org.example;

import java.util.ArrayList;
import java.util.List;

public class ShopService {

    private ProductRepo productRepo;
    private OrderRepo orderRepo;

    public ShopService(ProductRepo productRepo, OrderRepo orderRepo) {
        this.productRepo = productRepo;
        this.orderRepo = orderRepo;
    }

    public  void addOrder(int orderId , List<Integer> productsIds){

        List<Product> products = new ArrayList<>();
        for (int productId : productsIds){
            Product product = productRepo.getById(productId);
            if (product == null){
                System.out.println("Product with ID" + productId + "not Found");
                return;
            }
            products.add(product);
        }
        Order order = new Order(orderId, products);
        orderRepo.add(order);
    }
}
