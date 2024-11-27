package com.example.sell_airline_ticket.service.user.impl;


import com.example.sell_airline_ticket.entity.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.sell_airline_ticket.repository.FlightRepository;
import com.example.sell_airline_ticket.service.user.impl.FlightService;

import java.time.LocalDate;
import java.util.List;

@org.springframework.stereotype.Service
public class FlightServiceImp implements FlightService {
    @Autowired
    private FlightRepository flightRepo;
    @Override
    public List<Flight> getAllFlight(){
        return flightRepo.findAll();
    }

    @Override
    public List<Flight> searchFlights(String departure, String destination, LocalDate departureDate, LocalDate returnDate) {
        return flightRepo.searchFlights(departure, destination, departureDate, returnDate);
    }

}