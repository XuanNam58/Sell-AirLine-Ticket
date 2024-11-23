package com.example.sell_airline_ticket.controller.authentication;

import com.example.sell_airline_ticket.dto.request.AuthenticationRequest;
import com.example.sell_airline_ticket.dto.request.RegisterRequest;
import com.example.sell_airline_ticket.dto.response.AuthenticationResponse;
import com.example.sell_airline_ticket.dto.response.RegisterResponse;
import com.example.sell_airline_ticket.service.authentication.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> authenticateLogin(
            @RequestBody AuthenticationRequest request
    ) {
        AuthenticationResponse response = authService.authenticate(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/register")
    public ResponseEntity<RegisterResponse> registerAccount(
            @RequestBody RegisterRequest request
    ){
        RegisterResponse response = authService.registerNewAccount(request);
        return ResponseEntity.ok(response);
    }
}
