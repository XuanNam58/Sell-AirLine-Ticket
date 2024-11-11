package com.example.sell_airline_ticket.mapper;

import com.example.sell_airline_ticket.dto.response.SeatResponse;
import com.example.sell_airline_ticket.entity.Seat;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SeatMapper {
    @Mapping(target = "isBooked", ignore = true)
    SeatResponse toSeatResponse(Seat seat);
}
