package com.example.sell_airline_ticket.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SeatMessageResponse {
    Integer flightId;
    Integer seatNum;
    String status;
}
