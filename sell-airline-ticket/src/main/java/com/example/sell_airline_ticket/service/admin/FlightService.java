package com.example.sell_airline_ticket.service.admin;

import java.util.List;

import com.example.sell_airline_ticket.entity.Flight;

public interface FlightService {
    public List<Flight> getFlights();
    public void deleteFlight(Integer flightID);
    public Flight getFlightById(Integer flightID);
    public void saveFlight(Flight flight);

}
