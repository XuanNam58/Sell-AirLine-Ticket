package com.example.sell_airline_ticket.controller.admin;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.sell_airline_ticket.service.admin.TicketService;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@Controller
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequestMapping("/admin/ticket")
public class TicketController {
    TicketService ticketService;

    @GetMapping("/deleteticket/{flightID}/{seatNum}")
    public String deleteByFlightIDAndSeatNum(
            @PathVariable("flightID") Integer flightID,
            @PathVariable("seatNum") Integer seatNum,
            HttpServletRequest request,
            Model model) {
        model.addAttribute("currentUri", request.getRequestURI());
        ticketService.deleteByFlightIDAndSeatNum(flightID, seatNum);
        return "redirect:/admin/seat/" + flightID;
    }
}
