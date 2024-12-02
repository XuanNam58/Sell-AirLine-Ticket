package com.example.sell_airline_ticket.controller.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.sell_airline_ticket.entity.Service;
import com.example.sell_airline_ticket.entity.Ticket;
import com.example.sell_airline_ticket.service.user.TicketService;

@Controller
public class ServiceController {
    @Autowired
    com.example.sell_airline_ticket.service.user.impl.ServiceService serviceSer;

    @Autowired
    TicketService ticketSer;

    @GetMapping("/accomodation.html")
    public String accomodation(Model model) {
        List<Service> services = serviceSer.getAllService();
        List<Ticket> tickets = ticketSer.getAllTicketOfCus("0001");
        model.addAttribute("tickets", tickets);
        model.addAttribute("listService", services);
        return "user/accomodation";
    }

    @GetMapping("/service/detail/{serviceId}")
    public String serviceDetail(Model model, @PathVariable String serviceId) {
        Service service = serviceSer.getServiceById(serviceId);
        model.addAttribute("service", service);
        return "user/Service/service-detail";
    }
}
