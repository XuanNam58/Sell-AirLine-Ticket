
package com.example.sell_airline_ticket.service.user.impl;
import com.example.sell_airline_ticket.entity.Service;
import java.util.List;



public interface ServiceService {
    List<Service> getAllService();
    Service getServiceById(String id);
}
