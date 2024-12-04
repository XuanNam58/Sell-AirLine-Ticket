package com.example.sell_airline_ticket.controller.user;

import java.util.Map;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import com.example.sell_airline_ticket.entity.Service;
import com.example.sell_airline_ticket.entity.ServiceDetail;
import com.example.sell_airline_ticket.entity.Ticket;
import com.example.sell_airline_ticket.repository.ServiceDetailRepository;
import com.example.sell_airline_ticket.repository.ServiceRepository;
import com.example.sell_airline_ticket.repository.TicketRepository;
import com.example.sell_airline_ticket.service.user.impl.ServiceDetailUService;

@RestController
public class ServiceWork {
    @Autowired
    ServiceRepository serviceRepository;

    @Autowired
    TicketRepository ticketRepository;

    @Autowired
    ServiceDetailUService serviceDetailUService;

    @Autowired
    ServiceDetailRepository serviceDetailRepository;

    @PostMapping("/serviceOrder")
    public ResponseEntity<?> serviceOrder(@RequestBody Map<String, Object> data) {
        String serviceId = (String) data.get("serviceId");
        int ticketId = 0;
        try {
            ticketId = Integer.parseInt((String) data.get("ticketId"));
            Ticket ticket =
                    ticketRepository.findById(ticketId).orElseThrow(() -> new RuntimeException("Không tồn tại vé!"));
            Service service = serviceRepository
                    .findById(serviceId)
                    .orElseThrow(() -> new RuntimeException("Không tồn tại mã dịch vụ!"));
            ServiceDetail serviceDetail =
                    serviceDetailUService.getServiceDetailByTS(ticketId, serviceId.replace(" ", ""));
            if (serviceDetail != null) {
                serviceDetail.setQuantity(serviceDetail.getQuantity() + 1);
                serviceDetailRepository.save(serviceDetail);
            } else {
                ServiceDetail serviceDetail1 = new ServiceDetail();
                serviceDetail1.setQuantity(1);
                serviceDetail1.setService(service);
                serviceDetail1.setTicket(ticket);
                serviceDetailRepository.save(serviceDetail1);
            }
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }

        return ResponseEntity.ok(Map.of("message", "đặt thành công!"));
    }

}
