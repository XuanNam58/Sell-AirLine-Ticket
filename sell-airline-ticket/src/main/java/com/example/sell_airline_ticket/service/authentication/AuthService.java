package com.example.sell_airline_ticket.service.authentication;

import com.example.sell_airline_ticket.entity.AuthenticationRequest;
import com.example.sell_airline_ticket.entity.AuthenticationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Service;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.Authentication;


@Service
@RequiredArgsConstructor
public class AuthService {
    @Autowired
    private final AuthenticationManager authenticationManager;
    @Autowired
    private final JwtService jwtService;

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getUsername(),
                            request.getPassword()
                    )
            );

            String token = jwtService.generateToken(authentication);

            return AuthenticationResponse.builder()
                    .token(token)
                    .message("Đăng nhập thành công")
                    .success(true)
                    .build();

        } catch (AuthenticationException e) {
            return AuthenticationResponse.builder()
                    .message("Tên đăng nhập hoặc mật khẩu không đúng")
                    .success(false)
                    .build();
        }
    }
}