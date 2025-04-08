package com.example.sell_airline_ticket.service.user;

import com.example.sell_airline_ticket.entity.Flight;
import com.example.sell_airline_ticket.entity.Plane;
import com.example.sell_airline_ticket.repository.FlightRepository;
import com.example.sell_airline_ticket.service.user.impl.FlightServiceImp;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FlightServiceTest {
    @Mock
    FlightRepository flightRepository;

    @InjectMocks
    FlightServiceImp flightService;

    @Test
    void getAllFlight_ShouldReturnAllFlights() {
        // Arrange
        Flight flight1 = new Flight(1,new Plane("test01", "test01"), "Hanoi", "Ho Chi Minh", LocalDateTime.now(), LocalDateTime.now().plusHours(2), 200F);
        Flight flight2 = new Flight(2,  new Plane("test02", "test02"),"Da Nang", "Nha Trang",  LocalDateTime.now(), LocalDateTime.now().plusHours(2), 200F);
        List<Flight> expectedFlights = Arrays.asList(flight1, flight2);

        when(flightRepository.findAll()).thenReturn(expectedFlights);

        // Act
        List<Flight> actualFlights = flightService.getAllFlight();

        // Assert
        assertNotNull(actualFlights);
        assertEquals(2, actualFlights.size());
        assertEquals(expectedFlights, actualFlights);
        verify(flightRepository, times(1)).findAll();
    }

    @Test
    void getAllFlight_WhenNoFlightsExist_ShouldReturnEmptyList() {
        // Arrange
        when(flightRepository.findAll()).thenReturn(List.of());

        // Act
        List<Flight> actualFlights = flightService.getAllFlight();

        // Assert
        assertNotNull(actualFlights);
        assertTrue(actualFlights.isEmpty());
        verify(flightRepository, times(1)).findAll();
    }

    @Test
    void getAllFlight_ShouldCallRepositoryExactlyOnce() {
        // Arrange
        when(flightRepository.findAll()).thenReturn(List.of());

        // Act
        flightService.getAllFlight();

        // Assert
        verify(flightRepository, times(1)).findAll();
        verifyNoMoreInteractions(flightRepository);
    }

    /*Search flights*/
    @Test
    void searchFlights_WithPartialParameters_ShouldWork() {
        // Test with some parameters null
        Flight flight = new Flight(5, new Plane(), "Hanoi", "Da Lat",
                LocalDateTime.now(),
                LocalDateTime.now().plusHours(1), 180.0f);

        when(flightRepository.searchFlights("Hanoi", null, null, null))
                .thenReturn(Collections.singletonList(flight));

        List<Flight> result = flightService.searchFlights("Hanoi", null, null, null);

        assertEquals(1, result.size());
        assertEquals("Da Lat", result.get(0).getDestination());
    }

    @Test
    void searchFlights_ShouldHandleRepositoryExceptions() {
        when(flightRepository.searchFlights(anyString(), anyString(), any(LocalDate.class), any(LocalDate.class)))
                .thenThrow(new RuntimeException("Database error"));

        assertThrows(RuntimeException.class, () -> {
            flightService.searchFlights("Hanoi", "HCM", LocalDate.now(), null);
        });
    }
}
