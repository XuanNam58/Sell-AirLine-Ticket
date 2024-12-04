

package com.example.sell_airline_ticket.dto.response;

import com.example.sell_airline_ticket.entity.Service;
import com.example.sell_airline_ticket.entity.ServiceDetail;
import com.example.sell_airline_ticket.entity.Ticket;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ServiceResponse {
    int serviceDetailId;
    int ticketId;
    String serviceId;
    String serviceName;
    int quantity;

    public ServiceResponse(Ticket ticket, Service service, ServiceDetail serviceDetail) {
       this.serviceDetailId = serviceDetail.getServiceDetailId();
       this.ticketId = ticket.getTicketID();
       this.serviceId = service.getServiceId();
       this.serviceName = service.getServiceName();
       this.quantity = serviceDetail.getQuantity();
    }
}