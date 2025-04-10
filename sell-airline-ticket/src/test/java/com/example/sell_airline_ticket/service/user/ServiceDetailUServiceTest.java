package com.example.sell_airline_ticket.service.user;

import com.example.sell_airline_ticket.entity.ServiceDetail;
import com.example.sell_airline_ticket.repository.ServiceDetailRepository;
import com.example.sell_airline_ticket.service.user.impl.ServiceDetailUServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ServiceDetailUServiceTest {

    @InjectMocks
    private ServiceDetailUServiceImpl serviceDetailUService;

    @Mock
    private ServiceDetailRepository serviceRepo;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetServiceDetailByTS() {
        ServiceDetail mockDetail = new ServiceDetail();
        when(serviceRepo.getServiceDetailByTS(1, "SVC001")).thenReturn(mockDetail);

        ServiceDetail result = serviceDetailUService.getServiceDetailByTS(1, "SVC001");

        assertEquals(mockDetail, result);
        verify(serviceRepo, times(1)).getServiceDetailByTS(1, "SVC001");
    }

    @Test
    void testGetAllServiceDetail() {
        List<ServiceDetail> mockList = Arrays.asList(new ServiceDetail(), new ServiceDetail());
        when(serviceRepo.findAll()).thenReturn(mockList);

        List<ServiceDetail> result = serviceDetailUService.getAllServiceDetail();

        assertEquals(2, result.size());
        verify(serviceRepo, times(1)).findAll();
    }

    @Test
    void testDeleteByTicketId() {
        doNothing().when(serviceRepo).deleteByTicketId(1);

        serviceDetailUService.deleteByTicketId(1);

        verify(serviceRepo, times(1)).deleteByTicketId(1);
    }
}
