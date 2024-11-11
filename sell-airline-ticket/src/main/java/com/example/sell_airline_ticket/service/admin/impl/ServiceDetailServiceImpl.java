package com.example.sell_airline_ticket.service.admin.impl;

import com.example.sell_airline_ticket.repository.ServiceDetailRepository;
import com.example.sell_airline_ticket.repository.TicketRepository;
import com.example.sell_airline_ticket.service.admin.ServiceDetailService;
import com.example.sell_airline_ticket.service.admin.TicketService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ServiceDetailServiceImpl implements ServiceDetailService {
    ServiceDetailRepository serviceDetailRepository;

    @Transactional
    @Override
    public void deleteServiceDetailByFlightIDAndSeatNum(Integer flightID, Integer seatNum) {
        serviceDetailRepository.deleteServiceDetailByFlightIDAndSeatNum(flightID, seatNum);
    }
}
