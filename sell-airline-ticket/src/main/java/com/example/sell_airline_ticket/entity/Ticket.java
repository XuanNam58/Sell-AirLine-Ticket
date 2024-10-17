package com.example.sell_airline_ticket.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
    @Column(name = "TICKETID")
    String ticketID;
    String type;
    String departure;
    String destination;
    LocalDateTime depTime;
    LocalDateTime arrTime;
    String tax;
    boolean status;
    String userID;

}
