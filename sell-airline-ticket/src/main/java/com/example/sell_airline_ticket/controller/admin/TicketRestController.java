package com.example.sell_airline_ticket.controller.admin;

import com.example.sell_airline_ticket.service.admin.TicketService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequestMapping("/admin/ticket-rest")
public class TicketRestController {
    TicketService ticketService;
    @DeleteMapping("/deleteticket/{flightID}/{seatNum}")
    public ResponseEntity<Void> deleteByFlightIDAndSeatNum(@PathVariable("flightID") Integer flightID, @PathVariable("seatNum") Integer seatNum) {
        ticketService.deleteByFlightIDAndSeatNum(flightID, seatNum);
        return ResponseEntity.noContent().build();
    }
}
