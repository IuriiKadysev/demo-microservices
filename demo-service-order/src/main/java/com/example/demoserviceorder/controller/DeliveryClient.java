package com.example.demoserviceorder.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "service-delivery", url = "http://localhost:8100")
public interface DeliveryClient {
    @GetMapping("/api/delivery/accept-order")
    String sendOrderAccept();
}
