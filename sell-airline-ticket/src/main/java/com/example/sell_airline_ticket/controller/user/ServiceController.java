package com.example.sell_airline_ticket.controller.user;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import  org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.sell_airline_ticket.entity.Service;

import java.util.List;

@Controller
public class ServiceController {
    @Autowired
    com.example.sell_airline_ticket.service.user.impl.ServiceService serviceSer;
    @GetMapping("/accomodation.html")
    public String accomodation(Model model) {
        List<Service> services = serviceSer.getAllService();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        System.out.println(username);
        model.addAttribute("listService", services);
        return "user/accomodation";
    }


}