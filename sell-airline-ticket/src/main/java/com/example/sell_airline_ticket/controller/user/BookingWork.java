package com.example.sell_airline_ticket.controller.user;

import com.example.sell_airline_ticket.entity.Ticket;
import com.example.sell_airline_ticket.entity.Service;
import com.example.sell_airline_ticket.entity.ServiceDetail;
import com.example.sell_airline_ticket.repository.ServiceDetailRepository;
import com.example.sell_airline_ticket.service.user.impl.ServiceDetailUService;
import com.example.sell_airline_ticket.repository.ServiceRepository;
import com.example.sell_airline_ticket.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import java.util.Map;
import java.util.Optional;

import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/booking")
public class BookingWork{
    @Autowired
    com.example.sell_airline_ticket.repository.UserRepository userRepo;
    @Autowired
    com.example.sell_airline_ticket.repository.FlightRepository flightRepo;
    @Autowired
    TicketRepository ticketRepo;
    @PostMapping
    public ResponseEntity<?> booking(@RequestBody Map<String, Object> data) {
        String userId = (String) data.get("userId");
        com.example.sell_airline_ticket.entity.Flight flight = null;
        try {
            int flightId = Integer.parseInt((String) data.get("flightId"));
            flight = flightRepo.findById(flightId).orElseThrow(() -> new RuntimeException("Không tồn tại chuyến bay này!"));
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }
        String tax = (String) data.get("tax");
        int seat = (int) data.get("seat");
        com.example.sell_airline_ticket.entity.User user = userRepo.findById(userId).orElseThrow(() -> new RuntimeException("Không tồn tại khách hàng!"));


        Ticket ticket = new Ticket();
        ticket.setType("Một chiều");
        ticket.setTax(tax);
        ticket.setStatus(true);
        ticket.setSeatNum(seat);
        ticket.setFlight(flight);
        ticket.setUser(user);
        ticketRepo.save(ticket);
        return ResponseEntity.ok(Map.of("message", "Đặt vé thành công!"));
    }
}
