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
@Table(name = "ServiceDetail")
public class ServiceDetail {
    @Id
    @Column(name = "ServiceDetailId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer serviceDetailId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TicketId")
    Ticket ticket;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ServiceId")
    Service service;

    @Column(name = "Quantity")
    Integer quantity;
}
