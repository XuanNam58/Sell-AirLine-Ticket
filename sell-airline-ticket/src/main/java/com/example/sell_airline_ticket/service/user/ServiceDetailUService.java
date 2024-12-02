package com.example.sell_airline_ticket.service.user.impl;

import com.example.sell_airline_ticket.entity.ServiceDetail;

public interface ServiceDetailUService {
    ServiceDetail getServiceDetailByTS(int ticketID, String serviceId);
}
