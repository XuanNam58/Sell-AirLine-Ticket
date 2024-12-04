package com.example.sell_airline_ticket.controller.user;

import java.util.Map;

import com.example.sell_airline_ticket.dto.response.SeatMessageResponse;
import jakarta.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import com.example.sell_airline_ticket.entity.Ticket;
import com.example.sell_airline_ticket.repository.TicketRepository;

@RestController
public class BookingWork {
    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @Autowired
    com.example.sell_airline_ticket.repository.UserRepository userRepo;

    @Autowired
    com.example.sell_airline_ticket.repository.FlightRepository flightRepo;

    @Autowired
    TicketRepository ticketRepo;

    @PostMapping("/booking")
    public ResponseEntity<?> booking(@RequestBody Map<String, Object> data) {
        String userId = (String) data.get("userId");
        com.example.sell_airline_ticket.entity.Flight flight = null;
        int flightId = Integer.parseInt((String) data.get("flightId"));
        try {
            flight = flightRepo
                    .findById(flightId)
                    .orElseThrow(() -> new RuntimeException("Không tồn tại chuyến bay này!"));
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }
        String tax = (String) data.get("tax");
        int seat = (int) data.get("seat");
        com.example.sell_airline_ticket.entity.User user =
                userRepo.findById(userId).orElseThrow(() -> new RuntimeException("Không tồn tại khách hàng!"));

        Ticket ticket = new Ticket();
        ticket.setType("Một chiều");
        ticket.setTax(tax);
        ticket.setStatus(true);
        ticket.setSeatNum(seat);
        ticket.setFlight(flight);
        ticket.setUser(user);
        ticketRepo.save(ticket);

        SeatMessageResponse message = new SeatMessageResponse();
        message.setFlightId(flightId);
        message.setSeatNum(seat);
        message.setStatus("");
        String topic = "/topic/ticket-booked/" + message.getFlightId();
        messagingTemplate.convertAndSend(topic, message);

        return ResponseEntity.ok(Map.of("message", "Đặt vé thành công!"));
    }

    @GetMapping("/flightDetail-api/{flightId}")
    public String flightDetail(
            @RequestHeader("Authorization") String authorizationHeader,
            @PathVariable int flightId,
            HttpServletRequest request) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        request.getSession().setAttribute("currentUsername", username);
        return "redirect:flightDetail/" + flightId;
    }
}
