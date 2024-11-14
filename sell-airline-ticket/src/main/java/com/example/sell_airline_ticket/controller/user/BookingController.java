package com.example.sell_airline_ticket.controller.user;

import  org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.sell_airline_ticket.entity.Flight;

import java.util.List;
@Controller
public class BookingController {
    @Autowired
    private com.example.sell_airline_ticket.service.user.impl.FlightService flightSer;
    @GetMapping("/search.html")
    public String Search(Model model) {
        List<com.example.sell_airline_ticket.entity.Flight> flights = flightSer.getAllFlight();
        model.addAttribute("flights", flights);
        return "user/Service/ticket-booking-view";
    }
}
