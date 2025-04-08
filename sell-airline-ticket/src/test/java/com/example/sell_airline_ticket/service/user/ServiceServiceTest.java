package com.example.sell_airline_ticket.service.user.impl;

import com.example.sell_airline_ticket.entity.Service;
import com.example.sell_airline_ticket.repository.ServiceRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ServiceServiceTest {

    @InjectMocks
    private ServiceServiceImpl serviceService;

    @Mock
    private ServiceRepository serviceRepo;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllService() {
        List<Service> mockList = Arrays.asList(new Service(), new Service());
        when(serviceRepo.findAll()).thenReturn(mockList);

        List<Service> result = serviceService.getAllService();

        assertEquals(2, result.size());
        verify(serviceRepo, times(1)).findAll();
    }

    @Test
    void testGetServiceById_Success() {
        Service mockService = new Service();
        when(serviceRepo.findById("SVC001")).thenReturn(Optional.of(mockService));

        Service result = serviceService.getServiceById("SVC001");

        assertEquals(mockService, result);
        verify(serviceRepo, times(1)).findById("SVC001");
    }

    @Test
    void testGetServiceById_NotFound() {
        when(serviceRepo.findById("SVC999")).thenReturn(Optional.empty());

        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            serviceService.getServiceById("SVC999");
        });

        assertEquals("Không tồn tại mã dịch vụ!", exception.getMessage());
        verify(serviceRepo, times(1)).findById("SVC999");
    }
}
