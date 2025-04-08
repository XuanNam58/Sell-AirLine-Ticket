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

import java.util.List;

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
        Flight flight1 = new Flight(1, "VN123",new Plane("test01", "test01"), "Hanoi", "Ho Chi Minh", "");
        Flight flight2 = new Flight(2, "VN456", new Plane("test01", "test01"),"Da Nang", "Nha Trang");
        List<Flight> expectedFlights = Arrays.asList(flight1, flight2);

        when(flightRepo.findAll()).thenReturn(expectedFlights);

        // Act
        List<Flight> actualFlights = flightService.getAllFlight();

        // Assert
        assertNotNull(actualFlights);
        assertEquals(2, actualFlights.size());
        assertEquals(expectedFlights, actualFlights);
        verify(flightRepo, times(1)).findAll();
    }

    @Test
    void getAllFlight_WhenNoFlightsExist_ShouldReturnEmptyList() {
        // Arrange
        when(flightRepo.findAll()).thenReturn(List.of());

        // Act
        List<Flight> actualFlights = flightService.getAllFlight();

        // Assert
        assertNotNull(actualFlights);
        assertTrue(actualFlights.isEmpty());
        verify(flightRepo, times(1)).findAll();
    }

    @Test
    void getAllFlight_ShouldCallRepositoryExactlyOnce() {
        // Arrange
        when(flightRepo.findAll()).thenReturn(List.of());

        // Act
        flightService.getAllFlight();

        // Assert
        verify(flightRepo, times(1)).findAll();
        verifyNoMoreInteractions(flightRepo);
    }
}
