package com.example.sell_airline_ticket.service.admin;

import com.example.sell_airline_ticket.dto.response.CustomerResponse;
import com.example.sell_airline_ticket.dto.response.SeatResponse;

import java.util.List;

public interface TicketService {
   public void deleteByFlightIDAndSeatNum(Integer flightID, Integer seatNum);
}
