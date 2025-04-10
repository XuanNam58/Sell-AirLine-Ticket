package com.example.sell_airline_ticket.controller.user;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.example.sell_airline_ticket.service.user.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.sell_airline_ticket.util.StringUtils;

@Controller
public class BookingController {
    @Autowired
    private FlightService flightSer;

    @GetMapping("/search.html")
    public String Search(
            @RequestParam("departure") String departure,
            @RequestParam("destination") String destination,
            @RequestParam("departureDate") String departureDateStr,
            @RequestParam(value = "returnDate", required = false) String returnDateStr,
            @RequestParam("tripType") String tripType,
            Model model) {

        // Định dạng ngày giờ
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate departureDate = LocalDate.parse(departureDateStr.split(" ")[0], formatter);
        LocalDate returnDate;

        if (tripType.equals("Khứ hồi") && returnDateStr != null && !returnDateStr.isEmpty()) {
            returnDate = LocalDate.parse(returnDateStr.split(" ")[0], formatter);
        } else {
            returnDate = null;
        }

        List<com.example.sell_airline_ticket.entity.Flight> allFlights = flightSer.getAllFlight();

        //        boolean departureAvailable = allFlights.stream()
        //                .anyMatch(flight -> flight.getDepTime().toLocalDate().equals(departureDate));
        //
        //        boolean returnAvailable = allFlights.stream()
        //                .anyMatch(flight -> flight.getDepTime().toLocalDate().equals(returnDate));

        //        if (departureAvailable && returnAvailable) {
        model.addAttribute(
                "flights",
                flightSer.searchFlights(
                        StringUtils.capitalizeAndTrim(departure),
                        StringUtils.capitalizeAndTrim(destination),
                        departureDate,
                        returnDate));
        //        }

        return "user/Service/ticket-booking-view";
    }
}
