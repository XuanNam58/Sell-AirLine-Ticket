package com.example.sell_airline_ticket.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "Flight")
public class Flight {
    @Id
    @Column(name = "FlightID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer flightID;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PlaneID")
    Plane plane;
    @Column(name = "Departure", length = 50)
    String departure;
    @Column(name = "Destination", length = 50)
    String destination;
    @Column(name = "DepTime")
    LocalDateTime depTime;
    @Column(name = "ArrTime")
    LocalDateTime arrTime;
}
