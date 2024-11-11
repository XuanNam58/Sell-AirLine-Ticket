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
@Table(name = "[User]")
public class User {

    @Id
    @Column(name = "UserID", length = 10, nullable = false)
    String userID;

    @Column(name = "Name", length = 50, nullable = false)
    String name;

    @Column(name = "PhoneNum", length = 10, nullable = true)
    String phoneNum;

    @Column(name = "Email", length = 50, nullable = true)
    String email;

    @Column(name = "CitizenID", length = 12, nullable = false)
    String citizenID;

    @Column(name = "CreditNum", length = 20, nullable = true)
    String creditNum;

    @Column(name = "Status", nullable = false)
    Boolean status;

}

