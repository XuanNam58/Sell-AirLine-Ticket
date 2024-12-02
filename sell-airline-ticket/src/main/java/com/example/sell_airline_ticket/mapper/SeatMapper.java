package com.example.sell_airline_ticket.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.example.sell_airline_ticket.dto.response.SeatResponse;
import com.example.sell_airline_ticket.entity.Seat;

@Mapper(componentModel = "spring")
public interface SeatMapper {
    @Mapping(target = "isBooked", ignore = true)
    SeatResponse toSeatResponse(Seat seat);
}
