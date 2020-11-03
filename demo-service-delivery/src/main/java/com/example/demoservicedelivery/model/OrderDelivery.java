package com.example.demoservicedelivery.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@EqualsAndHashCode
@Table(name = "order_delivery")
public class OrderDelivery {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "order_name")
    private String orderName;

    @Column(name = "order_from")
    private String orderFrom;

    @Column(name = "order_to")
    private String orderTo;

    @Column(name = "courier_name")
    private String courierName;

    @Column(name = "order_time_completed")
    private LocalDateTime orderTimeCompleted;

    public OrderDelivery(String orderName, String orderFrom, String orderTo) {
        this.orderName = orderName;
        this.orderFrom = orderFrom;
        this.orderTo = orderTo;
    }

    public OrderDelivery(String orderName, String orderFrom, String orderTo, String courierName, LocalDateTime orderTimeCompleted) {
        this.orderName = orderName;
        this.orderFrom = orderFrom;
        this.orderTo = orderTo;
        this.courierName = courierName;
        this.orderTimeCompleted = orderTimeCompleted;
    }
}
