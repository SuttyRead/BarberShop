package com.barbershop.service;

import com.barbershop.domain.Order;
import com.barbershop.repository.impl.OrderDAOH2Impl;

import java.util.List;

public class OrderService {

    private OrderDAOH2Impl orderDAOH2;

    public OrderService() {
        orderDAOH2 = OrderDAOH2Impl.instance();
    }

     public void addOrder(Order order) {
        orderDAOH2.addOrder(order);
    }

    public List<Order> getAllOrders() {
       return orderDAOH2.getAllOrders();
    }

    public void deleteOrder(int id) {
        orderDAOH2.deleteOrder(id);
    }

}
