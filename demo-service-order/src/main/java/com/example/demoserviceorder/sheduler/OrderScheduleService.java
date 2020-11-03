package com.example.demoserviceorder.sheduler;

import com.example.demoserviceorder.client.DeliveryClient;
import com.example.demoserviceorder.model.Order;
import com.example.demoserviceorder.service.OrderService;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
@EnableScheduling
@Slf4j
public class OrderScheduleService {

    private final DeliveryClient deliveryClient;

    private final OrderService orderService;

    private final EurekaClient eurekaClient;

    private final AtomicLong atomicLong;

    @Autowired
    public OrderScheduleService(DeliveryClient deliveryClient, OrderService orderService, @Qualifier("eurekaClient") EurekaClient eurekaClient) {
        this.deliveryClient = deliveryClient;
        this.orderService = orderService;
        this.eurekaClient = eurekaClient;
        atomicLong = new AtomicLong();
    }

    @Scheduled(fixedRate = 5000)
    public void sendOrderAccept() {
        if (eurekaClient.getInstanceRemoteStatus().equals(InstanceInfo.InstanceStatus.UP)) {
            log.info("Send order accept to Delivery Service");
            List<Order> orderList = deliveryClient.sendOrderAccept().getBody();
            orderService.completeOrderList(orderList);
        }
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
