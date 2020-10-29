package com.example.demoserviceorder.service;

import com.example.demoserviceorder.model.Order;

import java.util.List;

public interface OrderService {
    void createOrder(Order order);
    Order getOrder(Long id);
    void modifyOrder(Order order);
    void completeOrder(Long id);
    void completeOrderList(List<Order> orderList);
    List<Order> getNewOrders();
    List<Order> getCompletedOrders();
    List<Order> getAllOrders();
    void deleteOrder(Long id);
}
