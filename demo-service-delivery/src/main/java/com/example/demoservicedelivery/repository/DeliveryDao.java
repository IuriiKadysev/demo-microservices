package com.example.demoservicedelivery.repository;

import com.example.demoservicedelivery.model.Order;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface DeliveryDao {
    void save(Order order);
    Order getById(Long id);
    List<Order> getNew();
    List<Order> getCompleted();
    void update(Order order);
    void deleteById(Long id);
    void deleteCompleted();
}
