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
@Table(name = "SEAT")
public class Seat {
    @Id
    @Column(name = "SEATID", length = 10, nullable = false)
    String seatID;
    @Column(name = "SEATNUM", nullable = true)
    Integer seatNum;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CLASSID")
    Class aClass;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PLANEID")
    Plane plane;
}
