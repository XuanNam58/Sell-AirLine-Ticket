package com.example.sell_airline_ticket.service.user;

import com.example.sell_airline_ticket.dto.response.CustomerResponse;
import com.example.sell_airline_ticket.dto.response.SeatResponse;
import com.example.sell_airline_ticket.entity.Ticket;

import java.util.List;

public interface TicketService {

    List<Ticket> getAllTicketOfCus(String userID);
    List<Ticket> searchTickets(int flightId);
}
