package com.example.sell_airline_ticket.service.admin.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.sell_airline_ticket.repository.TicketRepository;
import com.example.sell_airline_ticket.service.admin.ServiceDetailService;
import com.example.sell_airline_ticket.service.admin.TicketService;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class TicketServiceImpl implements TicketService {
    TicketRepository ticketRepository;
    ServiceDetailService serviceDetailService;

    @Transactional
    @Override
    public void deleteByFlightIDAndSeatNum(Integer flightID, Integer seatNum) {
        serviceDetailService.deleteServiceDetailByFlightIDAndSeatNum(flightID, seatNum);
        ticketRepository.deleteByFlightIDAndSeatNum(flightID, seatNum);
    }
}
