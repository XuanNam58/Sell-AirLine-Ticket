package com.example.sell_airline_ticket.service.admin;

import com.example.sell_airline_ticket.repository.ServiceDetailRepository;
import com.example.sell_airline_ticket.service.admin.impl.ServiceDetailServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ServiceDetailServiceTest {

    @Mock
    private ServiceDetailRepository serviceDetailRepository;

    @InjectMocks
    private ServiceDetailServiceImpl serviceDetailService;

    @Test
    void deleteServiceDetailByFlightIDAndSeatNum_ShouldCallRepository() {
        // Arrange
        Integer flightId = 1;
        Integer seatNum = 10;

        // Act
        serviceDetailService.deleteServiceDetailByFlightIDAndSeatNum(flightId, seatNum);

        // Assert
        verify(serviceDetailRepository, times(1))
                .deleteServiceDetailByFlightIDAndSeatNum(flightId, seatNum);
        verifyNoMoreInteractions(serviceDetailRepository);
    }

    @Test
    void deleteServiceDetailByFlightIDAndSeatNum_ShouldHandleNullParameters() {
        // Act
        serviceDetailService.deleteServiceDetailByFlightIDAndSeatNum(null, null);

        // Assert
        verify(serviceDetailRepository, times(1))
                .deleteServiceDetailByFlightIDAndSeatNum(null, null);
    }

    @Test
    void deleteServiceDetailByFlightIDAndSeatNum_ShouldHandleRepositoryException() {
        // Arrange
        Integer flightId = 1;
        Integer seatNum = 10;

        doThrow(new RuntimeException("Database error"))
                .when(serviceDetailRepository)
                .deleteServiceDetailByFlightIDAndSeatNum(flightId, seatNum);

        // Act & Assert
        assertThrows(RuntimeException.class, () ->
                serviceDetailService.deleteServiceDetailByFlightIDAndSeatNum(flightId, seatNum));
    }

    @Test
    void deleteServiceDetailByFlightIDAndSeatNum_ShouldVerifyCorrectParameters() {
        // Arrange
        Integer flightId = 123;
        Integer seatNum = 456;

        // Act
        serviceDetailService.deleteServiceDetailByFlightIDAndSeatNum(flightId, seatNum);

        // Assert
        verify(serviceDetailRepository, times(1))
                .deleteServiceDetailByFlightIDAndSeatNum(eq(flightId), eq(seatNum));
    }
}
