package com.example.demoservicedelivery.controller;

import com.example.demoservicedelivery.model.Order;
import com.example.demoservicedelivery.service.DeliveryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/delivery")
@Slf4j
public class DeliveryController {

    private final DeliveryService deliveryService;

    private final OrderClient orderClient;

    @Autowired
    public DeliveryController(DeliveryService deliveryService, OrderClient orderClient) {
        this.deliveryService = deliveryService;
        this.orderClient = orderClient;
    }

    @GetMapping("/get-new")
    public ResponseEntity<List<Order>> getNewOrders() {
        List<Order> orders = orderClient.getNewOrders();
        log.info("New orders from OrderClient {}", orders.size());
        deliveryService.addOrderList(orders);
        return ResponseEntity.ok(orders);
    }

    @GetMapping("/accept-order")
    public ResponseEntity<?> orderAccept() {
        List<Order> orders = orderClient.getNewOrders();
        deliveryService.addOrderList(orders);
        return ResponseEntity.ok().build();
    }
}
