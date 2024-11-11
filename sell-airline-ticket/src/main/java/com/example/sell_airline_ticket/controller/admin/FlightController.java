package com.example.sell_airline_ticket.controller.admin;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.example.sell_airline_ticket.entity.Flight;
import com.example.sell_airline_ticket.service.admin.PlaneService;
import jakarta.servlet.http.HttpServletRequest;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import com.example.sell_airline_ticket.service.admin.FlightService;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@Controller
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequestMapping("/admin/flight")
public class FlightController {
    FlightService flightService;
    PlaneService planeService;

    @GetMapping
    public String getFlights(HttpServletRequest request, Model model) {
        model.addAttribute("currentUri", request.getRequestURI());
        //        model.addAttribute("httpServletRequest", request);
        model.addAttribute("flightList", flightService.getFlights());
        return "admin/flight";
    }

    @GetMapping("/update-flight/{id}")
    public String updateFlight(@PathVariable Integer id, HttpServletRequest request, Model model) {
        model.addAttribute("currentUri", request.getRequestURI());
        model.addAttribute("flight", flightService.getFlightById(id));
        model.addAttribute("planeList", planeService.getPlanes());
        return "admin/update-flight";
    }

    @PostMapping("/save")
    public String saveFlight(@ModelAttribute("flight") Flight flight) {
        flightService.saveFlight(flight);
        return "redirect:/admin/flight";
    }

    @GetMapping("/delete/{id}")
    public String deleteFlight(@PathVariable("id") Integer id, HttpServletRequest request, Model model) {
        model.addAttribute("currentUri", request.getRequestURI());
        try {
            flightService.deleteFlight(id);
        } catch (DataIntegrityViolationException exception) {
            System.out.println(exception.getMessage());
        }

        return "redirect:/admin/flight";
    }

    @GetMapping("/create-flight")
    public String createFlight(HttpServletRequest request, Model model) {
        model.addAttribute("currentUri", request.getRequestURI());
        model.addAttribute("flight", new Flight());
        model.addAttribute("planeList", planeService.getPlanes());
        return "admin/create-flight";
    }
}
