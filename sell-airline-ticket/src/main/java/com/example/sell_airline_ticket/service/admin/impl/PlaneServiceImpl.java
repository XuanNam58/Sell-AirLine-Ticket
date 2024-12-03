package com.example.sell_airline_ticket.service.admin.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.sell_airline_ticket.entity.Plane;
import com.example.sell_airline_ticket.repository.PlaneRepository;
import com.example.sell_airline_ticket.service.admin.PlaneService;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

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
