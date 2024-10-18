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
@Table(name = "ACCOUNT")
public class Account {
    @Id
    @Column(name = "USERNAME", length = 20, nullable = false)
    String username;
    @Column(name = "PASSWORD", length = 30, nullable = false)
    String password;
    @OneToOne
    @JoinColumn(name = "USERID", referencedColumnName = "USERID")
    User user;
    @Column(name = "STATUS")
    Boolean status;
}
