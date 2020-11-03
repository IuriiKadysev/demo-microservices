package com.example.demoservicedelivery.service;

import com.example.demoservicedelivery.model.OrderDelivery;
import com.example.demoservicedelivery.repository.DeliveryDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class DeliveryServiceImpl implements DeliveryService {

    private final DeliveryDao deliveryDao;

    @Autowired
    public DeliveryServiceImpl(DeliveryDao deliveryDao) {
        this.deliveryDao = deliveryDao;
    }

    @Transactional
    @Override
    public void addOrderList(List<OrderDelivery> orderList) {
        for (OrderDelivery orderDelivery: orderList) {
            deliveryDao.save(orderDelivery);
        }
        log.info("Add order list to delivery Repository: {}", orderList.toString());
    }

    @Transactional
    @Override
    public void completeOrderList(List<OrderDelivery> orderList) {

    }

    @Transactional
    @Override
    public void updateOrder(OrderDelivery orderDelivery) {
        deliveryDao.update(orderDelivery);
    }

    @Transactional
    @Override
    public List<OrderDelivery> getNewOrders() {
        return deliveryDao.getNew();
    }

    @Transactional
    @Override
    public List<OrderDelivery> getCompletedOrders() {
        return deliveryDao.getCompleted();
    }

    @Transactional
    @Override
    public List<OrderDelivery> getAllOrders() {
        return null;
    }

    @Transactional
    @Override
    public void deleteCompletedOrders() {

    }
}
