package com.example.sell_airline_ticket.service.user.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.sell_airline_ticket.entity.ServiceDetail;
import com.example.sell_airline_ticket.repository.ServiceDetailRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

@org.springframework.stereotype.Service
public class ServiceDetailUServiceImpl
        implements com.example.sell_airline_ticket.service.user.impl.ServiceDetailUService {
    @Autowired
    private ServiceDetailRepository serviceRepo;

    @Override
    public ServiceDetail getServiceDetailByTS(int ticketID, String serviceId) {
        return serviceRepo.getServiceDetailByTS(ticketID, serviceId);
    }

    @Override
    public void deleteByTicketId(int ticketId){
        serviceRepo.deleteByTicketId(ticketId);
    };
}
