package com.example.demoservicedelivery.controller;

import com.example.demoservicedelivery.model.OrderDto;
import com.example.demoservicedelivery.service.DeliveryCourierService;
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

    private final DeliveryCourierService deliveryCourierService;

    @Autowired
    public DeliveryController(DeliveryService deliveryService, OrderClient orderClient, DeliveryCourierService deliveryCourierService) {
        this.deliveryService = deliveryService;
        this.orderClient = orderClient;
        this.deliveryCourierService = deliveryCourierService;
    }

    @GetMapping("/accept-order")
    public ResponseEntity<List<OrderDto>> getNewOrders() {
        List<OrderDto> ordersDto = deliveryCourierService.orderDeliveryCourier(orderClient.getNewOrders());
        log.info("New ordersDto from OrderClient {}", ordersDto.size());
        return ResponseEntity.ok(ordersDto);
    }

}
