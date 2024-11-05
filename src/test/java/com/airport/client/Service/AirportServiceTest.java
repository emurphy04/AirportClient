package com.airport.client.Service;

import com.airport.client.Model.Airport;
import com.airport.client.Service.AirportService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@SpringBootTest
public class AirportServiceTest {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private AirportService airportService;

    @Test
    public void testGetAirports() {
        // Mocking a ResponseEntity with an empty list as the body
        ResponseEntity<List<Airport>> responseEntity = ResponseEntity.ok(Collections.emptyList());
        when(restTemplate.exchange(
                eq("http://localhost:8080/airports"),
                eq(HttpMethod.GET),
                any(),
                eq(new ParameterizedTypeReference<List<Airport>>() {})
        )).thenReturn(responseEntity);

        // Verify method execution without issues
        airportService.getAirports();
    }

    @Test
    public void testAddAirport() {
        when(restTemplate.postForEntity(eq("http://localhost:8080/airports"), any(Airport.class), eq(Airport.class)))
                .thenReturn(ResponseEntity.ok(new Airport("New Airport", "NEW")));

        airportService.addAirport(new Airport("New Airport", "NEW"));
    }

    @Test
    public void testDeleteAirport() {
        airportService.deleteAirport(1);
    }

    @Test
    public void testUpdateAirport() {
        airportService.updateAirport(1, "Updated Airport", "UPD");
    }
}

