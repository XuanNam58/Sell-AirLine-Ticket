package com.example.sell_airline_ticket.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "Service")
public class Service {
    @Id
    @Column(name = "ServiceId", length = 10)
    String serviceId;

    @Column(name = "ServiceName", length = 10)
    String serviceName;

    @Column(name = "Price")
    int price;

    @Column(name = "Image")
    String image;
}
