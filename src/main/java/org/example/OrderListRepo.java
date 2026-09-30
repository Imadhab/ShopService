package org.example;

import java.util.ArrayList;
import java.util.List;

public class OrderListRepo implements OrderRepo {

    private List<Order> orders = new ArrayList<>();

    @Override
    public void add(Order order){
        orders.add(order);
    }

    @Override
    public void remove(Order order){
        orders.remove(order);
    }

    @Override
    public List<Order> getAll(){
        return orders;
    }

    @Override
    public Order getById(int id){
        for (Order order : orders) {
            if (order.id() == id) {
                return order;
            }
        }
        return null;
    }
}
