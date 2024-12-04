package com.example.sell_airline_ticket.controller.user;

import java.util.List;
import java.util.Optional;

import jakarta.servlet.http.HttpServletRequest;
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
    @Autowired
    com.example.sell_airline_ticket.repository.UserRepository userRepo;
    @Autowired
    com.example.sell_airline_ticket.repository.AccountRepository accountRepository;
    @GetMapping("/accomodation.html")
    public String serviceAcco(Model model, HttpServletRequest request) {
        String username = (String) request.getSession().getAttribute("currentUsername");

        Optional<com.example.sell_airline_ticket.entity.Account> account = accountRepository.findByUsername(username);
        String id = "";
        if (account.isPresent()) {
            String userId = account.get().getUser().getUserID();

            com.example.sell_airline_ticket.entity.User user =
                    userRepo.findById(userId).orElseThrow(() -> new RuntimeException("Không tồn tại khách hàng!"));

            id = user.getUserID();
        }
        List<Service> services = serviceSer.getAllService();
        List<Ticket> tickets = ticketSer.getAllTicketOfCus(id);
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
