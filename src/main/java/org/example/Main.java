package org.example;


import java.util.List;

public class Main {
    static void main(String[] args) {
        ProductRepo productRepo = new ProductRepo();

        Product product1 = new Product(1, "Laptop");
        Product product2 = new Product(2, "Mouse");
        Product product3 = new Product(3, "Keyboard");

        productRepo.add(product1);
        productRepo.add(product2);
        productRepo.add(product3);

        OrderRepo orderRepo = new OrderMapRepo();

        ShopService shopService = new ShopService(productRepo, orderRepo);

        shopService.addOrder(1, List.of(1, 2));

        System.out.println(orderRepo.getAll());
        }
    }

