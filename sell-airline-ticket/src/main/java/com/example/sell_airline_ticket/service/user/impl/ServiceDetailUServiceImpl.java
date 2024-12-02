package com.example.sell_airline_ticket.service.user.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.sell_airline_ticket.entity.ServiceDetail;
import com.example.sell_airline_ticket.repository.ServiceDetailRepository;

@org.springframework.stereotype.Service
public class ServiceDetailUServiceImpl implements ServiceDetailUService {
    @Autowired
    private ServiceDetailRepository serviceRepo;

    @Override
    public ServiceDetail getServiceDetailByTS(int ticketID, String serviceId) {
        return serviceRepo.getServiceDetailByTS(ticketID, serviceId);
    }
}
