package com.example.sell_airline_ticket.service.user;

import java.util.List;

import com.example.sell_airline_ticket.entity.Ticket;

public interface TicketService {

    List<Ticket> getAllTicketOfCus(String userID);

    List<Ticket> searchTickets(int flightId);
}
