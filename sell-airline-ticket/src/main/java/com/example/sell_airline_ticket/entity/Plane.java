package com.example.sell_airline_ticket.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "Plane")
public class Plane {
    @Id
    @Column(name = "PlaneID", length = 10, nullable = false)
    String planeID;
    @Column(name = "Name", length = 10, nullable = false)
    String name;
}
