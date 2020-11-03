package com.example.demoservicedelivery.controller;

import com.example.demoservicedelivery.model.OrderDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient("service-order")
public interface OrderClient {
    @GetMapping("/api/orderDtos/get-new")
    List<OrderDto> getNewOrders();

    @PostMapping("/api/orderDtos/mark-done")
    String markOrdersDone(List<OrderDto> orderDtoList);
}
