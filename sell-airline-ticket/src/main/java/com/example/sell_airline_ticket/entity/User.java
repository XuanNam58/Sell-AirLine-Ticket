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
@Table(name = "USER")
public class User {

    @Id
    @Column(name = "USERID", length = 10, nullable = false)
    String userID;

    @Column(name = "FIRSTNAME", length = 20, nullable = false)
    String firstName;

    @Column(name = "LASTNAME", length = 50, nullable = false)
    String lastName;

    @Column(name = "PHONENUM", length = 10, nullable = true)
    String phoneNum;

    @Column(name = "EMAIL", length = 50, nullable = true)
    String email;

    @Column(name = "CITIZENID", length = 12, nullable = false)
    String citizenID;

    @Column(name = "CREDITNUM", length = 20, nullable = true)
    String creditNum;

    @Column(name = "STATUS", nullable = false)
    boolean status;
}

