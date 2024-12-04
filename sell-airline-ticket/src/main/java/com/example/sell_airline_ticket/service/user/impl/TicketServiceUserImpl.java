package com.example.sell_airline_ticket.service.user.impl;

import java.util.List;

import org.hibernate.tool.schema.spi.SqlScriptException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sell_airline_ticket.entity.Ticket;
import com.example.sell_airline_ticket.repository.TicketRepository;
import com.example.sell_airline_ticket.service.user.TicketService;

@Service
public class TicketServiceUserImpl implements TicketService {
    @Autowired
    TicketRepository ticketRepository;

    @Override
    public List<Ticket> getAllTicketOfCus(String userID) {
        return ticketRepository.getAllTicketOfCus(userID);
    }

    @Override
    public List<Ticket> searchTickets(int flightId) {
        return ticketRepository.searchTickets(flightId);
    }

    @Override
    public boolean cancelSeat(int ticketId) {
        try {
            ticketRepository.deleteById(ticketId);
        } catch (SqlScriptException e){
            return false;
        }
        return true;
    }
}
