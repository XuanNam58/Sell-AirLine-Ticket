package com.example.sell_airline_ticket.service.authentication;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.sell_airline_ticket.entity.Account;
import com.example.sell_airline_ticket.entity.User;
import com.example.sell_airline_ticket.repository.AccountRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private AccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountRepository
                .findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Không tìm thấy tài khoản: " + username));

        User user = account.getUser();
        if (user == null) {
            throw new UsernameNotFoundException("Không tìm thấy thông tin người dùng cho tài khoản: " + username);
        }

        String role = "USER";
        if ("admin".equalsIgnoreCase(username)) {
            role = "ADMIN";
        }

        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_" + role));

        return org.springframework.security.core.userdetails.User.builder()
                .username(account.getUsername())
                .password(account.getPassword())
                .disabled(!account.getStatus())
                .authorities(authorities)
                .build();
    }
}
