package com.example.sell_airline_ticket.entity;

import jakarta.persistence.*;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "Seat")
public class Seat {
    @Id
    @Column(name = "SeatId", length = 10, nullable = false)
    String seatID;

    @Column(name = "SeatNum", nullable = true)
    Integer seatNum;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ClassId")
    Class aClass;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PlaneId")
    Plane plane;
}
