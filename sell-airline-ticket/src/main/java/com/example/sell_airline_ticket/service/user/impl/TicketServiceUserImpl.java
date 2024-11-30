package com.example.sell_airline_ticket.service.user.impl;

import com.example.sell_airline_ticket.repository.TicketRepository;

import com.example.sell_airline_ticket.service.user.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.sell_airline_ticket.entity.Ticket;

import java.util.List;

@Service

public class TicketServiceUserImpl implements TicketService {
    @Autowired
    TicketRepository ticketRepository;

    @Override
    public List<Ticket> getAllTicketOfCus(String userID){
        return ticketRepository.getAllTicketOfCus(userID);
    }

    @Override
    public List<Ticket> searchTickets(int flightId){
        return ticketRepository.searchTickets(flightId);
    }
}
