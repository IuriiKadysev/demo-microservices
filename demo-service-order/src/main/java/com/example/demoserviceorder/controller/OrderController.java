package com.example.demoserviceorder.controller;

import com.example.demoserviceorder.model.Order;
import com.example.demoserviceorder.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orderDtos")
@Slf4j
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/get-new")
    public ResponseEntity<List<Order>> getNewOrders() {
        List<Order> orderList = orderService.getNewOrders();
        log.info("List new orderDtos size: {}", orderList.size());
        return ResponseEntity.ok(orderList);
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<Order>> getAllOrders() {
        List<Order> orderList = orderService.getAllOrders();
        log.info("List all orderDtos size: {}", orderList.size());
        return ResponseEntity.ok(orderList);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createOrder(@RequestBody Order order) {
        orderService.createOrder(order);
        log.info("Order created: {}", order.getOrderName());
        return ResponseEntity.ok().build();
    }

    @PutMapping("/mark-done")
    public ResponseEntity<?> markCompleted(@RequestBody List<Order> orderList) {
        orderService.completeOrderList(orderList);
        log.info("Orders completed: {}", orderList.size());
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteOrder(@RequestBody Order order) {
        orderService.deleteOrder(order.getId());
        log.info("Order deleted");
        return ResponseEntity.ok().build();
    }


}
