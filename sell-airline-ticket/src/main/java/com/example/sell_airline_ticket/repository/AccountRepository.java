package com.example.sell_airline_ticket.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.sell_airline_ticket.entity.Account;
import com.example.sell_airline_ticket.entity.User;

@Repository
public interface AccountRepository extends JpaRepository<Account, String> {
    Optional<Account> findByUsername(String username);

    Optional<Account> findByUser(User user);
}
