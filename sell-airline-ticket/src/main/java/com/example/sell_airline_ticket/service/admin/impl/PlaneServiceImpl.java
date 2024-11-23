package com.example.sell_airline_ticket.service.admin.impl;

import com.example.sell_airline_ticket.dto.response.SeatResponse;
import com.example.sell_airline_ticket.entity.Plane;
import com.example.sell_airline_ticket.mapper.SeatMapper;
import com.example.sell_airline_ticket.repository.PlaneRepository;
import com.example.sell_airline_ticket.repository.SeatRepository;
import com.example.sell_airline_ticket.service.admin.PlaneService;
import com.example.sell_airline_ticket.service.admin.SeatService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PlaneServiceImpl implements PlaneService {
    PlaneRepository planeRepository;

    @Override
    public List<Plane> getPlanes() {
        return planeRepository.findAll();
    }
}
