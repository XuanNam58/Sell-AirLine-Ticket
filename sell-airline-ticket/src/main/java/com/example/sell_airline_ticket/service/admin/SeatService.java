package com.example.sell_airline_ticket.service.admin;

import java.util.List;

import com.example.sell_airline_ticket.dto.response.CustomerResponse;
import com.example.sell_airline_ticket.dto.response.SeatResponse;

public interface SeatService {
    public List<SeatResponse> getSeats(Integer flightID);

    public CustomerResponse getCustomerInfo(Integer flightID, String seatID);
}
