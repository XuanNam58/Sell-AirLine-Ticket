package com.example.sell_airline_ticket.controller.user;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.example.sell_airline_ticket.dto.response.SeatMessageResponse;

@Controller
public class WebSocketController {
    @MessageMapping("/seat/select")
    @SendTo("/topic/flight/{flightId}")
    public SeatMessageResponse selectSeat(SeatMessageResponse message) {
        return message;
    }
}
