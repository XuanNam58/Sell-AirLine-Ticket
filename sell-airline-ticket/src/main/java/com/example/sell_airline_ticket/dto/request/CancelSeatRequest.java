package com.example.sell_airline_ticket.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class CancelSeatRequest {
    Integer ticketId;
}
