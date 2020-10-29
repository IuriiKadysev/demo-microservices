package com.example.demoserviceorder.service;

import com.example.demoserviceorder.controller.DeliveryClient;
import com.example.demoserviceorder.model.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicLong;

@Service
@EnableScheduling
@Slf4j
public class OrderScheduleService {

    private final DeliveryClient deliveryClient;

    private final OrderService orderService;

    private AtomicLong atomicLong;

    @Autowired
    public OrderScheduleService(DeliveryClient deliveryClient, OrderService orderService) {
        this.deliveryClient = deliveryClient;
        this.orderService = orderService;
        atomicLong = new AtomicLong();
    }

    @Scheduled(fixedRate = 5000)
    public void sendOrderAccept() {
        log.info("Send order accept to Delivery Service");
        deliveryClient.sendOrderAccept();
    }

    @Scheduled(fixedRate = 1500)
    public void createOrders() {
        atomicLong.getAndIncrement();
        String name = atomicLong.toString();
        Order order = new Order(name + " order", "from " + name, "to " + name, LocalDateTime.now());
        orderService.createOrder(order);
        log.info("New Order {} created", order.getOrderName());
    }
}
