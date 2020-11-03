package com.example.demoservicedelivery.repository;

import com.example.demoservicedelivery.model.OrderDelivery;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface DeliveryDao {
    void save(OrderDelivery orderDelivery);
    OrderDelivery getById(Long id);
    List<OrderDelivery> getNew();
    List<OrderDelivery> getCompleted();
    void update(OrderDelivery orderDelivery);
    void deleteById(Long id);
    void deleteCompleted();
}
