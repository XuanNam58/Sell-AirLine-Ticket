package com.example.sell_airline_ticket.service.admin;

import com.example.sell_airline_ticket.entity.Plane;
import com.example.sell_airline_ticket.repository.PlaneRepository;
import com.example.sell_airline_ticket.service.admin.impl.PlaneServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PlaneServiceTest {

    @Mock
    private PlaneRepository planeRepository;

    @InjectMocks
    private PlaneServiceImpl planeService;

    @Test
    void getPlanes_ShouldReturnAllPlanes() {
        // Arrange
        Plane plane1 = new Plane("Test01", "Boeing 737");
        Plane plane2 = new Plane("Test02", "Airbus A320");
        List<Plane> expectedPlanes = Arrays.asList(plane1, plane2);

        when(planeRepository.findAll()).thenReturn(expectedPlanes);

        // Act
        List<Plane> result = planeService.getPlanes();

        // Assert
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals(expectedPlanes, result);
        verify(planeRepository, times(1)).findAll();
    }

    @Test
    void getPlanes_WhenNoPlanesExist_ShouldReturnEmptyList() {
        // Arrange
        when(planeRepository.findAll()).thenReturn(Collections.emptyList());

        // Act
        List<Plane> result = planeService.getPlanes();

        // Assert
        assertNotNull(result);
        assertTrue(result.isEmpty());
        verify(planeRepository, times(1)).findAll();
    }

    @Test
    void getPlanes_ShouldCallRepositoryExactlyOnce() {
        // Arrange
        when(planeRepository.findAll()).thenReturn(Collections.emptyList());

        // Act
        planeService.getPlanes();

        // Assert
        verify(planeRepository, times(1)).findAll();
        verifyNoMoreInteractions(planeRepository);
    }

    @Test
    void getPlanes_ShouldReturnCorrectPlaneDetails() {
        // Arrange
        Plane plane = new Plane("Test03", "Boeing 787");
        when(planeRepository.findAll()).thenReturn(Collections.singletonList(plane));

        // Act
        List<Plane> result = planeService.getPlanes();

        // Assert
        assertEquals(1, result.size());
        assertEquals("Test03", result.get(0).getPlaneID());
        assertEquals("Boeing 787", result.get(0).getName());
    }
}
