
package com.example.sell_airline_ticket.service.user.impl;
import com.example.sell_airline_ticket.entity.ServiceDetail;
import org.springframework.stereotype.Service;

import java.util.List;



public interface ServiceDetailUService {
    ServiceDetail getServiceDetailByTS(int ticketID, String serviceId);
}