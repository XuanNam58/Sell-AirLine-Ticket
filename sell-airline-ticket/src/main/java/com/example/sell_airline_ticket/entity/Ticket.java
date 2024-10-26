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
@Table(name = "Ticket")
public class Ticket {
    @Id
    @Column(name = "TicketID", length = 10, nullable = false)
    String ticketID;
    @Column(name = "Type", length = 15, nullable = true)
    String type;
    @Column(name = "Tax", nullable = true)
    Float tax;
    @Column(name = "STATUS")
    Boolean status;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UserID")
    User user;
    Integer seatNum;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FlightID")
    Flight flight;
}
