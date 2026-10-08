package org.example;


import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class Main {
    static void main(String[] args) {
        ProductRepo productRepo = new ProductRepo();

        Product product1 = new Product(1, "Laptop", new BigDecimal("99.90"));
        Product product2 = new Product(2, "Mouse", new BigDecimal("29.99"));
        Product product3 = new Product(3, "Keyboard",new BigDecimal("39.99"));

        productRepo.add(product1);
        productRepo.add(product2);
        productRepo.add(product3);

        OrderRepo orderRepo = new OrderMapRepo();

        ShopService shopService = new ShopService(productRepo, orderRepo);

        shopService.addOrder(1, Map.of(1, 2,2,3));
        shopService.addOrder(2, Map.of(2, 1,3,3));
        shopService.addOrder(3, Map.of(1, 2,3,3));
        Order order = orderRepo.getById(1);

        System.out.println(orderRepo.getAll());
        List<Order> processingOrders = shopService.getOrdersByStatus(OrderStatus.PROCESSING);
        System.out.println(processingOrders);

        System.out.println("Gesamtsumme:" + order.getTotalPrice() + "€");

//        System.out.println(orderRepo.getAll());

//        shopService.addOrder(1, Map.of(1, 2,2,3));
//        shopService.addOrder(2, Map.of(1, 2,3,4));
//        shopService.addOrder(3, Map.of(1, 2,2,3));

        shopService.updateOrder(1, OrderStatus.IN_DELIVERY);
        System.out.println(orderRepo.getById(2));

        // getAll() für alle Bestellungen
//        System.out.println(orderRepo.getAll();

        }
    }

