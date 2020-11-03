package com.example.demoservicedelivery.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;


@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@EqualsAndHashCode
public class OrderDto {

    private Long id;

    private String orderName;

    private String orderFrom;

    private String orderTo;

    private LocalDateTime orderTimeCreated;

    private LocalDateTime orderTimeCompleted;

    private boolean orderCompleted;

    public OrderDto(String orderName, String orderFrom, String orderTo, LocalDateTime orderTimeCreated) {
        this.orderName = orderName;
        this.orderFrom = orderFrom;
        this.orderTo = orderTo;
        this.orderTimeCreated = orderTimeCreated;
    }
}
