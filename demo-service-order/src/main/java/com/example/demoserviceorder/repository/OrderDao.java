package com.example.demoserviceorder.repository;

import com.example.demoserviceorder.model.Order;

import java.util.List;

public interface OrderDao {
    void save(Order order);
    Order getById(Long id);
    List<Order> getNew();
    List<Order> getCompleted();
    void update(Order order);
    void updateCompleted(List<Order> orderList);
    void deleteById(Long id);
    void deleteCompleted();
}
