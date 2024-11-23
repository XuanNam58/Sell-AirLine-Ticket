package com.example.sell_airline_ticket.service.admin;

import com.example.sell_airline_ticket.dto.response.SeatResponse;
import com.example.sell_airline_ticket.entity.Plane;

import java.util.List;

public interface PlaneService {
    public List<Plane> getPlanes();
}
