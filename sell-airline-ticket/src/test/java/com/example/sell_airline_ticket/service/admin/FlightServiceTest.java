package com.example.sell_airline_ticket.service.admin;

import com.example.sell_airline_ticket.entity.Flight;
import com.example.sell_airline_ticket.repository.FlightRepository;
import com.example.sell_airline_ticket.service.admin.impl.FlightServiceImpl;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FlightServiceTest {
    @Mock
    FlightRepository flightRepository;

    @InjectMocks
    FlightServiceImpl flightService;

    @Test
    void getFlightById_WhenFlightExists_ShouldReturnFlight() {
        Integer flightId = 1;
        Flight expectedFlight = new Flight();
        when(flightRepository.findById(flightId)).thenReturn(Optional.of(expectedFlight));

        Flight result = flightService.getFlightById(flightId);

        assertNotNull(result);
        assertEquals(expectedFlight, result);
//        xác nhận flightRepository chỉ gọi 1 lần
        verify(flightRepository, times(1)).findById(flightId);
    }

    @Test
    void getFlightById_WhenFlightNotExists_ShouldThrowException() {
        Integer flightId = 99;
        when(flightRepository.findById(flightId)).thenReturn(Optional.empty());

        RuntimeException exception = assertThrows(RuntimeException.class, ()->flightService.getFlightById(flightId));

        assertEquals("Không tìm thấy chuyến bay.", exception.getMessage());
        verify(flightRepository, times(1)).findById(flightId);
    }

}
