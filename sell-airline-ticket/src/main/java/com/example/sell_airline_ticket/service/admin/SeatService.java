package com.example.sell_airline_ticket.service.admin;

import com.example.sell_airline_ticket.dto.response.CustomerResponse;
import com.example.sell_airline_ticket.dto.response.SeatResponse;
import com.example.sell_airline_ticket.entity.Seat;

import java.util.List;

public interface SeatService {
    public List<SeatResponse> getSeats(Integer flightID);
    public  CustomerResponse getCustomerInfo(Integer flightID, String seatID);
}
