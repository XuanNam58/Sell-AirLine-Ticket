package com.example.sell_airline_ticket.service.admin.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.sell_airline_ticket.entity.Flight;
import com.example.sell_airline_ticket.repository.FlightRepository;
import com.example.sell_airline_ticket.service.admin.FlightService;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class FlightServiceImpl implements FlightService {
    FlightRepository flightRepository;

    @Override
    public List<Flight> getFlights() {
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
//        List<Flight> flightList = flightRepository.findAll();
//        for (Flight flight : flightList){
//            String arrTimeString = flight.getArrTime().toString();
//            LocalDateTime arrTimeLDT = LocalDateTime.parse(arrTimeString, formatter);
//
//            String depTimeString = flight.getDepTime().toString();
//            LocalDateTime depTimeLDT = LocalDateTime.parse(depTimeString, formatter);
//
//            flight.setArrTime(arrTimeLDT);
//            flight.setDepTime(depTimeLDT);
//
//        }
        return flightRepository.findAll();
    }

    @Override
    public void deleteFlight(Integer flightID) {
        flightRepository.deleteById(flightID);
    }

    @Override
    public Flight getFlightById(Integer flightID) {
        return flightRepository.findById(flightID).orElseThrow(() -> new
                RuntimeException("Không tìm thấy chuyến bay."));
    }

    @Override
    public void saveFlight(Flight flight) {
        flightRepository.save(flight);
    }


}
