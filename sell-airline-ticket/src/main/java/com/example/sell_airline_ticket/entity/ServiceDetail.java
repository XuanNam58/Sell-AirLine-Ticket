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
@IdClass(ServiceDetailID.class)
public class ServiceDetail {
    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TicketID")
    Ticket ticket;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ServiceID")
    Service service;

}
