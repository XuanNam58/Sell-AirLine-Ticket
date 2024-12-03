package com.example.sell_airline_ticket.service.user.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.sell_airline_ticket.entity.Flight;
import com.example.sell_airline_ticket.repository.FlightRepository;

@org.springframework.stereotype.Service
public class FlightServiceImp implements com.example.sell_airline_ticket.service.user.impl.FlightService {
    @Autowired
    private FlightRepository flightRepo;

    @Override
    public List<Flight> getAllFlight() {
        return flightRepo.findAll();
    }

    @Override
    public List<Flight> searchFlights(
            String departure, String destination, LocalDate departureDate, LocalDate returnDate) {
        return flightRepo.searchFlights(departure, destination, departureDate, returnDate);
    }
}
