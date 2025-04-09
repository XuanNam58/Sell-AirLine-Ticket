package com.example.sell_airline_ticket.service.admin;

import com.example.sell_airline_ticket.dto.response.CustomerResponse;
import com.example.sell_airline_ticket.dto.response.SeatResponse;
import com.example.sell_airline_ticket.repository.SeatRepository;
import com.example.sell_airline_ticket.service.admin.impl.SeatServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SeatServiceTest {

    @Mock
    private SeatRepository seatRepository;

    @InjectMocks
    private SeatServiceImpl seatService;

    @Test
    void getSeats_ShouldReturnSeatResponses() {
        // Arrange
        Integer flightId = 1;
        SeatResponse seat1 = new SeatResponse("A1", 5, false);
        SeatResponse seat2 = new SeatResponse("B2", 6, true);

        when(seatRepository.getSeats(flightId)).thenReturn(Arrays.asList(seat1, seat2));

        // Act
        List<SeatResponse> result = seatService.getSeats(flightId);

        // Assert
        assertEquals(2, result.size());
        assertEquals("A1", result.get(0).getSeatID());
        assertFalse(result.get(0).getIsBooked());
        assertEquals("B2", result.get(1).getSeatID());
        assertTrue(result.get(1).getIsBooked());

        verify(seatRepository).getSeats(flightId);
    }

    @Test
    void getSeats_ShouldReturnEmptyListWhenNoSeats() {
        // Arrange
        Integer flightId = 1;
        when(seatRepository.getSeats(flightId)).thenReturn(List.of());

        // Act
        List<SeatResponse> result = seatService.getSeats(flightId);

        // Assert
        assertTrue(result.isEmpty());
        verify(seatRepository).getSeats(flightId);
    }

    /*Get customer info*/
    @Test
    void getCustomerInfo_ShouldReturnCustomerResponse() {
        // Arrange
        Integer flightId = 1;
        String seatId = "A1";
        CustomerResponse expectedResponse = new CustomerResponse("123", "John Doe", "123456789");

        when(seatRepository.getCustomerInfo(flightId, seatId)).thenReturn(expectedResponse);

        // Act
        CustomerResponse result = seatService.getCustomerInfo(flightId, seatId);

        // Assert
        assertNotNull(result);
        assertEquals(123, result.getUserID());
        assertEquals("John Doe", result.getName());
        assertEquals("123456789", result.getPhoneNum());

        verify(seatRepository).getCustomerInfo(flightId, seatId);
    }

    @Test
    void getCustomerInfo_ShouldReturnNullWhenNoCustomer() {
        // Arrange
        Integer flightId = 1;
        String seatId = "B2";

        when(seatRepository.getCustomerInfo(flightId, seatId)).thenReturn(null);

        // Act
        CustomerResponse result = seatService.getCustomerInfo(flightId, seatId);

        // Assert
        assertNull(result);
        verify(seatRepository).getCustomerInfo(flightId, seatId);
    }
}
