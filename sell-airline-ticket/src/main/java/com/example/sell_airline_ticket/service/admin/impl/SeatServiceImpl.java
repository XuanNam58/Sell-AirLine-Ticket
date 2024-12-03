package com.example.sell_airline_ticket.service.admin.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.sell_airline_ticket.dto.response.CustomerResponse;
import com.example.sell_airline_ticket.dto.response.SeatResponse;
import com.example.sell_airline_ticket.repository.SeatRepository;
import com.example.sell_airline_ticket.service.admin.SeatService;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class SeatServiceImpl implements SeatService {
    SeatRepository seatRepository;
    //    SeatMapper seatMapper;

    @Override
    public List<SeatResponse> getSeats(Integer flightID) {
        //        List<Seat> seatInFlight = seatRepository.getSeatsInFlight(flightID);
        //        List<Seat> seatInTicket = seatRepository.getSeatsInTicket(flightID);
        //        List<SeatResponse> seatList = seatInFlight.stream()
        //                .map(seat -> {
        //                    SeatResponse response = seatMapper.toSeatResponse(seat);
        //                    response.setIsBooked(false);
        //                    return response;
        //                }).toList();
        //        for (Seat seat : seatInFlight) {
        //            if (seatInTicket.contains(seat)) {
        //                seatList.stream()
        //                        .filter(seatResponse -> seatResponse.getSeatID().equals(seat.getSeatID()))
        //                        .findFirst()
        //                        .ifPresent(seatResponse -> seatResponse.setIsBooked(true));
        //            }
        //        }
        return seatRepository.getSeats(flightID);
    }

    @Override
    public CustomerResponse getCustomerInfo(Integer flightID, String seatID) {
        return seatRepository.getCustomerInfo(flightID, seatID);
    }
}
