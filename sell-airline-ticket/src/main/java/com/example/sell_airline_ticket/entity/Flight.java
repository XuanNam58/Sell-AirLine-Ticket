package com.example.sell_airline_ticket.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "Flight")
public class Flight {
    @Id
    @Column(name = "FlightId", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer flightID;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "PlaneId")
    com.example.sell_airline_ticket.entity.Plane plane;

    @Column(name = "Departure", length = 50)
    String departure;

    @Column(name = "Destination", length = 50)
    String destination;

    @Column(name = "DepTime")
    LocalDateTime depTime;

    @Column(name = "ArrTime")
    LocalDateTime arrTime;

    @Column(name = "Price")
    float price;
}
