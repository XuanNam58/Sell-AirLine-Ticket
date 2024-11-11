package com.example.sell_airline_ticket.dto.response;

import com.example.sell_airline_ticket.entity.Class;
import com.example.sell_airline_ticket.entity.Plane;
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
