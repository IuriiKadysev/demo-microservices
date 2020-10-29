package com.example.demoservicedelivery.controller;

import com.example.demoservicedelivery.model.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient(name = "service-order", url = "http://localhost:8000")
public interface OrderClient {
    @GetMapping("/api/orders/get-new")
    List<Order> getNewOrders();

    @PostMapping("/api/orders/mark-done")
    String markOrdersDone(List<Order> orderList);
}
