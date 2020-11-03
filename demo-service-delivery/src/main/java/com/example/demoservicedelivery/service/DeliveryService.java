package com.example.demoservicedelivery.service;

import com.example.demoservicedelivery.model.OrderDelivery;

import java.util.List;

public interface DeliveryService {
    void addOrderList(List<OrderDelivery> deliveryList);
    void completeOrderList(List<OrderDelivery> deliveryList);
    void updateOrder(OrderDelivery orderDelivery);
    List<OrderDelivery> getNewOrders();
    List<OrderDelivery> getCompletedOrders();
    List<OrderDelivery> getAllOrders();
    void deleteCompletedOrders();
}
