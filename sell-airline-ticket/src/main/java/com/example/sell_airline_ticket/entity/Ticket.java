package com.example.sell_airline_ticket.entity;

import jakarta.persistence.*;

import lombok.*;
import lombok.experimental.FieldDefaults;
import com.example.sell_airline_ticket.entity.User;
import com.example.sell_airline_ticket.entity.Flight;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "Ticket")
public class Ticket {
    @Id
    @Column(name = "TicketId", length = 10, nullable = false)
    String ticketID;

    @Column(name = "Type", length = 15, nullable = true)
    String type;

    @Column(name = "Tax", nullable = true)
    Float tax;

    @Column(name = "Status")
    Boolean status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UserId")
    User user;
    @Column(name = "Seat_Num")
    Integer seatNum;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Flight_Id")
     Flight flight;
}
