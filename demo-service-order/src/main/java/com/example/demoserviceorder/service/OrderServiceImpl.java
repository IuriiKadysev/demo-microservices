package com.example.demoserviceorder.service;

import com.example.demoserviceorder.model.Order;
import com.example.demoserviceorder.repository.OrderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderDao orderDao;

    @Autowired
    public OrderServiceImpl(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    @Transactional
    @Override
    public void createOrder(Order order) {
        orderDao.save(order);
    }

    @Transactional
    @Override
    public Order getOrder(Long id) {
        return orderDao.getById(id);
    }

    @Transactional
    @Override
    public void modifyOrder(Order order) {
        orderDao.update(order);
    }

    @Transactional
    @Override
    public void completeOrder(Long id) {

    }

    @Transactional
    @Override
    public void completeOrderList(List<Order> orderList) {
        for (Order order : orderList) {
            orderDao.update(order);
        }
    }

    @Transactional
    @Override
    public List<Order> getNewOrders() {
        return orderDao.getNew();
    }

    @Transactional
    @Override
    public List<Order> getCompletedOrders() {
        return orderDao.getCompleted();
    }

    @Transactional
    @Override
    public List<Order> getAllOrders() {
        return new ArrayList<>();
    }

    @Transactional
    @Override
    public void deleteOrder(Long id) {

    }
}
