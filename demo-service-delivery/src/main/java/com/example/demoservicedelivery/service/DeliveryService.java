package com.example.demoservicedelivery.service;

import com.example.demoservicedelivery.model.Order;

import java.util.List;

public interface DeliveryService {
    void addOrderList(List<Order> orderList);
    void completeOrderList(List<Order> orderList);
    void updateOrder(Order order);
    List<Order> getNewOrders();
    List<Order> getCompletedOrders();
    List<Order> getAllOrders();
    void deleteCompletedOrders();
}
