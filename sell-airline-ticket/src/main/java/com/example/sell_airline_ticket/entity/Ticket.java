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
@Table(name = "Ticket")
public class Ticket {
    @Id
    @Column(name = "TicketId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int ticketID;

    @Column(name = "Type", length = 15, nullable = true)
    String type;

    @Column(name = "Tax", nullable = true)
    String tax;

    @Column(name = "Status")
    Boolean status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UserId")
    com.example.sell_airline_ticket.entity.User user;

    @Column(name = "Seat_Num")
    Integer seatNum;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Flight_Id")
    com.example.sell_airline_ticket.entity.Flight flight;
}
