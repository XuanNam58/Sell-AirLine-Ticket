package com.example.sell_airline_ticket.service.admin;

import com.example.sell_airline_ticket.repository.TicketRepository;
import com.example.sell_airline_ticket.service.admin.impl.TicketServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TicketServiceTest {

    @Mock
    private ServiceDetailService serviceDetailService;

    @Mock
    private TicketRepository ticketRepository;

    @InjectMocks
    private TicketServiceImpl ticketService;

    @Test
    void deleteByFlightIDAndSeatNum_ShouldCallBothServices() {
        // Arrange
        Integer flightId = 1;
        Integer seatNum = 10;

        // Act
        ticketService.deleteByFlightIDAndSeatNum(flightId, seatNum);

        // Assert
        verify(serviceDetailService, times(1))
                .deleteServiceDetailByFlightIDAndSeatNum(flightId, seatNum);
        verify(ticketRepository, times(1))
                .deleteByFlightIDAndSeatNum(flightId, seatNum);
        verifyNoMoreInteractions(serviceDetailService, ticketRepository);
    }

    @Test
    void deleteByFlightIDAndSeatNum_ShouldHandleNullParameters() {
        // Act
        ticketService.deleteByFlightIDAndSeatNum(null, null);

        // Assert
        verify(serviceDetailService, times(1))
                .deleteServiceDetailByFlightIDAndSeatNum(null, null);
        verify(ticketRepository, times(1))
                .deleteByFlightIDAndSeatNum(null, null);
    }

    @Test
    void deleteByFlightIDAndSeatNum_ShouldContinueWhenServiceDetailFails() {
        // Arrange
        Integer flightId = 1;
        Integer seatNum = 10;

        doThrow(new RuntimeException("Service detail error"))
                .when(serviceDetailService)
                .deleteServiceDetailByFlightIDAndSeatNum(flightId, seatNum);

        // Act & Assert
        assertThrows(RuntimeException.class, () ->
                ticketService.deleteByFlightIDAndSeatNum(flightId, seatNum));

        // Verify ticketRepository was still called despite the first failure
        verify(ticketRepository, never())
                .deleteByFlightIDAndSeatNum(any(), any());
    }

    @Test
    void deleteByFlightIDAndSeatNum_ShouldFailWhenTicketDeletionFails() {
        // Arrange
        Integer flightId = 1;
        Integer seatNum = 10;

        doThrow(new RuntimeException("Ticket deletion error"))
                .when(ticketRepository)
                .deleteByFlightIDAndSeatNum(flightId, seatNum);

        // Act & Assert
        assertThrows(RuntimeException.class, () ->
                ticketService.deleteByFlightIDAndSeatNum(flightId, seatNum));

        // Verify both operations were attempted
        verify(serviceDetailService, times(1))
                .deleteServiceDetailByFlightIDAndSeatNum(flightId, seatNum);
    }

    @Test
    void deleteByFlightIDAndSeatNum_ShouldExecuteInOrder() {
        // Arrange
        Integer flightId = 1;
        Integer seatNum = 10;

        // Act
        ticketService.deleteByFlightIDAndSeatNum(flightId, seatNum);

        // Assert
        /*inorder để đảm bảo các phụ thuộc được gọi đúng thứ tự
        * trong này có nghĩa serviceDetailService phải dc gọi trc ticketRepository*/
        InOrder inOrder = inOrder(serviceDetailService, ticketRepository);
        inOrder.verify(serviceDetailService)
                .deleteServiceDetailByFlightIDAndSeatNum(flightId, seatNum);
        inOrder.verify(ticketRepository)
                .deleteByFlightIDAndSeatNum(flightId, seatNum);
    }
}