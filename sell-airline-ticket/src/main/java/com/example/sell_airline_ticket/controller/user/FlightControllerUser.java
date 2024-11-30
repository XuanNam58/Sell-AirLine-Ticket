package com.example.sell_airline_ticket.controller.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import  org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.example.sell_airline_ticket.entity.Ticket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class FlightControllerUser {
    @Autowired
    com.example.sell_airline_ticket.repository.FlightRepository flightRepository;
    @Autowired
    com.example.sell_airline_ticket.repository.TicketRepository ticketRepo;
    @Autowired
    com.example.sell_airline_ticket.service.user.TicketService ticketService;
    @Autowired
    com.example.sell_airline_ticket.repository.UserRepository userRepo;
    @GetMapping("/flightDetail/{flightId}")
    public String flightDetail(@PathVariable int flightId, Model model) {
        List<Integer> numbers = IntStream.rangeClosed(1, 10)
                .boxed()
                .collect(Collectors.toList());
        model.addAttribute("numbers", numbers);
        com.example.sell_airline_ticket.entity.Flight flight = flightRepository.findById(flightId).orElseThrow(() -> new RuntimeException("Không tồn tại mã chuyến bay!"));
        model.addAttribute("flight", flight);

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        System.out.println(username);

        com.example.sell_airline_ticket.entity.User user = userRepo.findById("0001").orElseThrow(() -> new RuntimeException("Không tồn tại khách hàng!"));
        model.addAttribute("user", user);

        List<Boolean> booleanList = new ArrayList<>(Collections.nCopies(10, false));
        List<Ticket> tickets = ticketService.searchTickets(flightId);

        for(Ticket ticket : tickets) {
            int seatNum = ticket.getSeatNum();
            if (seatNum >= 1 && seatNum <= 10) {
                booleanList.set(seatNum - 1, true);
            }
        }
        System.out.println(booleanList);
        model.addAttribute("seatsCheck", booleanList);
        return "user/Booking/flightDetail";
    }
}
