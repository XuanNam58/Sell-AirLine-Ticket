package com.example.sell_airline_ticket.service.user.impl;

import java.util.List;

import com.example.sell_airline_ticket.entity.Service;

public interface ServiceService {
    List<Service> getAllService();

    Service getServiceById(String id);
}
