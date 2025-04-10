package com.example.sell_airline_ticket.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SeatResponse {
    String seatID;
    Integer seatNum;
    //    Class aClass;
    Boolean isBooked;
}
