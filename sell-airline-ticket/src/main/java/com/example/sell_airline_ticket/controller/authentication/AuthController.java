package com.example.sell_airline_ticket.controller.authentication;

import com.example.sell_airline_ticket.dto.request.CancelSeatRequest;
import com.example.sell_airline_ticket.dto.response.FlightTicketResponse;
import com.example.sell_airline_ticket.dto.response.SeatMessageResponse;
import com.example.sell_airline_ticket.entity.Flight;
import com.example.sell_airline_ticket.entity.Ticket;
import com.example.sell_airline_ticket.entity.User;
import com.example.sell_airline_ticket.repository.FlightRepository;
import com.example.sell_airline_ticket.repository.TicketRepository;
import com.example.sell_airline_ticket.service.user.TicketService;
import com.example.sell_airline_ticket.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.example.sell_airline_ticket.dto.request.AuthenticationRequest;
import com.example.sell_airline_ticket.dto.request.RegisterRequest;
import com.example.sell_airline_ticket.dto.response.AuthenticationResponse;
import com.example.sell_airline_ticket.dto.response.RegisterResponse;
import com.example.sell_airline_ticket.service.authentication.AuthService;
import com.example.sell_airline_ticket.service.authentication.JwtService;

import java.util.List;
import java.util.Optional;

@Controller
public class AuthController {
    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @Autowired
    private JwtService jwtService;
    @Autowired
    private AuthService authService;
    @Autowired
    private UserService userService;
    @Autowired
    private TicketService ticketService;
    @Autowired
    private TicketRepository ticketRepository;


    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> authenticateLogin(@RequestBody AuthenticationRequest request) {
        AuthenticationResponse response = authService.authenticate(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/register")
    public ResponseEntity<RegisterResponse> registerAccount(@RequestBody RegisterRequest request) {
        RegisterResponse response = authService.registerNewAccount(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/user/info")
    public ResponseEntity<?> getUserInfo(@RequestHeader("Authorization") String authorizationHeader) {
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            String token = authorizationHeader.substring(7);

            if (jwtService.isTokenValid(token)) {
                String username = jwtService.extractUsername(token);
                User userInfo = userService.getUserByUsername(username);
                return ResponseEntity.ok(userInfo);
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Token không hợp lệ");
            }
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Token không tồn tại");
    }

    @GetMapping("/user/flight")
    public ResponseEntity<?> getUserFlight(@RequestHeader("Authorization") String authorizationHeader) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        if (username != null) {
            List<FlightTicketResponse> flightTicketResponsesList = userService.getFlightByUsername(username);
            return ResponseEntity.ok(flightTicketResponsesList);
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Token không tồn tại");
    }

    @PostMapping("/cancel-ticket/{ticketId}")
    public ResponseEntity<String> cancelSeat(@PathVariable int ticketId) {

        SeatMessageResponse message = new SeatMessageResponse();
        Optional<Ticket> ticketOtp = ticketRepository.findById(ticketId);
        if (ticketOtp.isPresent()) {
            message.setFlightId(ticketOtp.get().getFlight().getFlightID());
            message.setSeatNum(ticketOtp.get().getSeatNum());
            message.setStatus("unselected");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ticket not found.");
        }
        boolean success = ticketService.cancelSeat(ticketId);

        if (success) {
            String topic = "/topic/cancel-flight/" + message.getFlightId();
            messagingTemplate.convertAndSend(topic, message);
            return ResponseEntity.ok("Seat canceled successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to cancel seat.");
        }
    }
}