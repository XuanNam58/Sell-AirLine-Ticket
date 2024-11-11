package com.example.sell_airline_ticket.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "Flight")
public class Flight {
    @Id
    @Column(name = "FlightID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer flightID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PlaneID")
    Plane plane;

    @Column(name = "Departure", length = 50)
    String departure;

    @Column(name = "Destination", length = 50)
    String destination;

    @Column(name = "DepTime", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    LocalDateTime depTime;

    @Column(name = "ArrTime", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    LocalDateTime arrTime;
}
