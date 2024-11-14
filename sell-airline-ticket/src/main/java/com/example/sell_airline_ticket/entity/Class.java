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
@Table(name = "Class")
public class Class {
    @Id
    @Column(name = "ClassId", length = 10, nullable = false)
    String classID;
    @Column(name = "ClassName", length = 10, nullable = true)
    String className;
    @Column(name = "Price", nullable = false)
    Float price;
}
