package com.example.sell_airline_ticket.service.user.impl;


import com.example.sell_airline_ticket.entity.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.sell_airline_ticket.repository.ServiceRepository;
import com.example.sell_airline_ticket.service.user.impl.ServiceService;
import java.util.List;

@org.springframework.stereotype.Service
public class ServiceServiceImpl implements ServiceService {
    @Autowired
    private ServiceRepository serviceRepo;
    @Override
    public List<Service> getAllService(){
        return serviceRepo.findAll();
    }
    @Override
    public Service getServiceById(String serviceId){
        return serviceRepo.findById(serviceId).orElseThrow(() -> new RuntimeException("Không tồn tại mã dịch vụ!"));
    }

}
