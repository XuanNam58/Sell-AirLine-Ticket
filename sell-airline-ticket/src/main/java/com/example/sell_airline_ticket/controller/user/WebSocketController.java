package com.example.sell_airline_ticket.controller.user;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import com.example.sell_airline_ticket.dto.response.SeatMessageResponse;

@Controller
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class WebSocketController {
    SimpMessagingTemplate messagingTemplate;
    @MessageMapping("/seat/select")
//    @SendTo("/topic/flight/{flightId}")
    public void selectSeat(SeatMessageResponse message) {
        Integer flightId = message.getFlightId();
        String topic = "/topic/flight/" + flightId;

        messagingTemplate.convertAndSend(topic, message);
    }
}
