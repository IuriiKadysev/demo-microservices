package com.example.demoserviceorder.client;

import com.example.demoserviceorder.model.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient("service-delivery")
public interface DeliveryClient {
    @GetMapping("/api/delivery/accept-order")
    ResponseEntity<List<Order>> sendOrderAccept();
}
