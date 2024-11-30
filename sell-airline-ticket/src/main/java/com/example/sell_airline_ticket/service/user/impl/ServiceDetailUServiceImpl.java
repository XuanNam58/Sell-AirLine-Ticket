package com.example.sell_airline_ticket.service.user.impl;


import com.example.sell_airline_ticket.entity.ServiceDetail;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.sell_airline_ticket.repository.ServiceDetailRepository;
import com.example.sell_airline_ticket.service.user.impl.ServiceDetailUService;
import java.util.List;

@org.springframework.stereotype.Service
public class ServiceDetailUServiceImpl implements ServiceDetailUService {
    @Autowired
    private ServiceDetailRepository serviceRepo;
    @Override
    public ServiceDetail getServiceDetailByTS(int ticketID,String serviceId){
        return serviceRepo.getServiceDetailByTS(ticketID,serviceId);
    }

}