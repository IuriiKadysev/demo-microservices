package com.example.demoservicedelivery.service;

import com.example.demoservicedelivery.model.OrderDelivery;
import com.example.demoservicedelivery.model.OrderDto;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class DeliveryCourierService {

    private final DeliveryService deliveryService;

    private final List<String> courierList;

    @Autowired
    public DeliveryCourierService(DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
        courierList = new ArrayList<>();
        courierList.add("Courier Vasya");
        courierList.add("Courier Petya");
        courierList.add("Courier Semeon");
    }

    @SneakyThrows
    public List<OrderDto> orderDeliveryCourier(List<OrderDto> orderDtoList) {
        List<OrderDto> orderDtoListFromCourier = new ArrayList<>();
        List<OrderDelivery> orderDeliveries = new ArrayList<>();
        Random random = new Random();

        for (OrderDto orderDto: orderDtoList) {
            orderDto.setOrderCompleted(true);
            orderDto.setOrderTimeCompleted(LocalDateTime.now());
            orderDtoListFromCourier.add(orderDto);
        }

        for (OrderDto orderDto: orderDtoList) {
            orderDeliveries.add(new OrderDelivery(
                    orderDto.getOrderName(),
                    orderDto.getOrderFrom(),
                    orderDto.getOrderTo(),
                    courierList.get(random.nextInt(courierList.size())),
                    orderDto.getOrderTimeCompleted()
            ));
        }

        deliveryService.addOrderList(orderDeliveries);

        return orderDtoListFromCourier;
    }

}
