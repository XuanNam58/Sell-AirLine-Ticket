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
@Table(name = "TICKET")
public class Ticket {
    @Id
    @Column(name = "TICKETID", length = 10, nullable = false)
    String ticketID;
    @Column(name = "TYPE", length = 15, nullable = true)
    String type;
    @Column(name = "DEPARTURE", length = 50, nullable = true)
    String departure;
    @Column(name = "DESTINATION", length = 50, nullable = true)
    String destination;
    @Column(name = "DEPTIME", nullable = true)
    LocalDateTime depTime;
    @Column(name = "ARRTIME", nullable = true)
    LocalDateTime arrTime;
    @Column(name = "TAX", nullable = true)
    Float tax;
    @Column(name = "STATUS")
    Boolean status;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USERID")
    User user;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SEATID")
    Seat seat;
}
