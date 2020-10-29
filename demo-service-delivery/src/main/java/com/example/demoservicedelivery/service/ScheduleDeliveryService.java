package com.example.demoservicedelivery.service;

import com.example.demoservicedelivery.controller.OrderClient;
import com.example.demoservicedelivery.model.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@EnableScheduling
@Slf4j
public class ScheduleDeliveryService {

    private final OrderClient orderClient;

    private final DeliveryService deliveryService;

    @Autowired
    public ScheduleDeliveryService(OrderClient orderClient, DeliveryService deliveryService) {
        this.orderClient = orderClient;
        this.deliveryService = deliveryService;
    }

    @Scheduled(fixedRate = 1600)
    public void deliveryOrder() {
        List<Order> orderList = deliveryService.getNewOrders();
        for (Order order: orderList) {
            order.setOrderCompleted(true);
            order.setOrderTimeCompleted(LocalDateTime.now());
            deliveryService.updateOrder(order);
        }
    }

    @Scheduled(fixedRate = 6000)
    public void transferCompleted() {
        List<Order> listCompleted = deliveryService.getCompletedOrders();
        orderClient.markOrdersDone(listCompleted);
        log.info("List Delivery completed Orders transfer {}", listCompleted.size());
    }
}
