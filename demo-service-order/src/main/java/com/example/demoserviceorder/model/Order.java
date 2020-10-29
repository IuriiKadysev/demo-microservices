package com.example.demoserviceorder.model;

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
@Table(name = "order_values")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "order_name")
    private String orderName;

    @Column(name = "order_from")
    private String orderFrom;

    @Column(name = "order_to")
    private String orderTo;

    @Column(name = "order_time_created")
    private LocalDateTime orderTimeCreated;

    @Column(name = "order_time_completed")
    private LocalDateTime orderTimeCompleted;

    @Column(name = "order_completed")
    private boolean orderCompleted;

    public Order(String orderName, String orderFrom, String orderTo, LocalDateTime orderTimeCreated) {
        this.orderName = orderName;
        this.orderFrom = orderFrom;
        this.orderTo = orderTo;
        this.orderTimeCreated = orderTimeCreated;
    }
}
