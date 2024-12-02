package com.example.sell_airline_ticket.configuration;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.sell_airline_ticket.entity.Account;
import com.example.sell_airline_ticket.entity.User;
import com.example.sell_airline_ticket.repository.AccountRepository;
import com.example.sell_airline_ticket.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        if (userRepository.count() == 0) {
            userRepository.saveAll(List.of(
                    User.builder()
                            .userID("0001")
                            .name("Nguyen Van An")
                            .phoneNum("0123456789")
                            .email("vanan@gmail.com")
                            .citizenID("0123123123")
                            .creditNum("0111222333")
                            .status(true)
                            .build(),
                    User.builder()
                            .userID("1001")
                            .name("Tran Ngoc Ba")
                            .phoneNum("0123321123")
                            .email("ngocba@gmail.com")
                            .citizenID("1234565432")
                            .creditNum("0567567567")
                            .status(true)
                            .build()));
        }

        if (accountRepository.count() == 0) {
            Optional<User> user = userRepository.findById("0001");
            if (user.isPresent()) {
                accountRepository.saveAll(List.of(Account.builder()
                        .username("customer01")
                        .password("$2y$10$MG6jaQZk49xYO95xMxt6UO5pk.sA1htpEZppNcKY7iRudengtwzmO")
                        .user(user.get())
                        .status(true)
                        .build()));
            }
            Optional<User> admin = userRepository.findById("1001");
            if (user.isPresent()) {
                accountRepository.saveAll(List.of(Account.builder()
                        .username("admin")
                        .password("$2y$10$MG6jaQZk49xYO95xMxt6UO5pk.sA1htpEZppNcKY7iRudengtwzmO")
                        .user(user.get())
                        .status(true)
                        .build()));
            }
        }
    }
}
