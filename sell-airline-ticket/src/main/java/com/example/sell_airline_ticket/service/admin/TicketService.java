package com.example.sell_airline_ticket.service.admin;

public interface TicketService {
    public void deleteByFlightIDAndSeatNum(Integer flightID, Integer seatNum);
}
