package com.example.sell_airline_ticket.controller.admin;

import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.sell_airline_ticket.dto.response.SeatResponse;
import com.example.sell_airline_ticket.service.admin.SeatService;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@Controller
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequestMapping("/admin/seat")
public class SeatController {

    SeatService seatService;

    @GetMapping("/{flightID}")
    public String getSeats(@PathVariable Integer flightID, HttpServletRequest request, Model model) {
        List<SeatResponse> seatList = seatService.getSeats(flightID);
        model.addAttribute("currentUri", request.getRequestURI());
        model.addAttribute("seatList", seatList);

        List<List<SeatResponse>> partitionedSeats = new ArrayList<>();
        //        System.out.println(seatService.getSeats(flightID).stream().toList());
        int partitionSize = 6;

        for (int i = 0; i < seatList.size(); i += partitionSize) {
            partitionedSeats.add(seatList.subList(i, Math.min(i + partitionSize, seatList.size())));
        }

        model.addAttribute("flightID", flightID);
        model.addAttribute("partitionedSeats", partitionedSeats);
        return "admin/seat";
    }
}
