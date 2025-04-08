package com.example.sell_airline_ticket.service.user.impl;

import com.example.sell_airline_ticket.entity.Ticket;
import com.example.sell_airline_ticket.repository.TicketRepository;
import org.hibernate.tool.schema.spi.SqlScriptException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TicketServiceUserTest {

    @InjectMocks
    private TicketServiceUserImpl ticketService;

    @Mock
    private TicketRepository ticketRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllTicketOfCus() {
        List<Ticket> mockTickets = Arrays.asList(new Ticket(), new Ticket());
        when(ticketRepository.getAllTicketOfCus("user123")).thenReturn(mockTickets);

        List<Ticket> result = ticketService.getAllTicketOfCus("user123");

        assertEquals(2, result.size());
        verify(ticketRepository, times(1)).getAllTicketOfCus("user123");
    }

    @Test
    void testSearchTickets() {
        List<Ticket> mockTickets = Arrays.asList(new Ticket());
        when(ticketRepository.searchTickets(101)).thenReturn(mockTickets);

        List<Ticket> result = ticketService.searchTickets(101);

        assertEquals(1, result.size());
        verify(ticketRepository, times(1)).searchTickets(101);
    }

    @Test
    void testCancelSeat_Success() {
        // Giả lập xóa không có lỗi
        doNothing().when(ticketRepository).deleteById(5);

        boolean result = ticketService.cancelSeat(5);

        assertTrue(result);
        verify(ticketRepository, times(1)).deleteById(5);
    }

    @Test
    void testCancelSeat_Exception() {
        // Giả lập lỗi SQL khi xóa
        doThrow(new SqlScriptException("DB error")).when(ticketRepository).deleteById(99);

        boolean result = ticketService.cancelSeat(99);

        assertFalse(result);
        verify(ticketRepository, times(1)).deleteById(99);
    }
}
