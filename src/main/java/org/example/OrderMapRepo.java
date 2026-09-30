package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderMapRepo  implements OrderRepo{
    private Map<Integer, Order> orders = new HashMap<>();


    @Override
    public void add(Order order) {
        orders.put(order.id(), order);
    }

    @Override
    public void remove(Order order) {
        orders.remove(order.id(), order);
    }

    @Override
    public Order getById(int id) {
        return orders.get(id);
    }

    @Override
    public List<Order> getAll() {
        return new ArrayList<>(orders.values());
    }
}
