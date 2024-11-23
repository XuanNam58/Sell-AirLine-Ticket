package com.example.sell_airline_ticket.entity;

import jakarta.persistence.*;

import lombok.*;
import lombok.experimental.FieldDefaults;
import com.example.sell_airline_ticket.entity.Ticket;
import com.example.sell_airline_ticket.entity.Service;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "ServiceDetail")
public class ServiceDetail {
    @Id
    @Column(name = "ServiceDetailID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer serviceDetailID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TicketID")
    Ticket ticket;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ServiceID")
    Service service;
}
