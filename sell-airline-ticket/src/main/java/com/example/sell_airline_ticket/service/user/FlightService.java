package com.example.sell_airline_ticket.service.user;

import java.time.LocalDate;
import java.util.List;

import com.example.sell_airline_ticket.entity.Flight;

public interface FlightService {
    List<Flight> getAllFlight();

    List<Flight> searchFlights(String departure, String destination, LocalDate departureDate, LocalDate returnDate);
}
