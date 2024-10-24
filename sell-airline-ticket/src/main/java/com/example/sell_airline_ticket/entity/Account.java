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
@Table(name = "Account")
public class Account {
    @Id
    @Column(name = "Username", length = 20, nullable = false)
    String username;
    @Column(name = "Password", length = 30, nullable = false)
    String password;
    @OneToOne
    @JoinColumn(name = "UserID", referencedColumnName = "USERID")
    User user;
    @Column(name = "Status")
    Boolean status;
}
