package com.airport.client.Service;

import com.airport.client.Model.Flight;
import com.airport.client.Model.FlightAdder;
import com.airport.client.Service.FlightService;
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
public class FlightServiceTest {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private FlightService flightService;

    @Test
    public void testGetFlights() {
        ResponseEntity<List<Flight>> responseEntity = ResponseEntity.ok(Collections.emptyList());
        when(restTemplate.exchange(
                eq("http://localhost:8080/flights"),
                eq(HttpMethod.GET),
                any(),
                eq(new ParameterizedTypeReference<List<Flight>>() {})
        )).thenReturn(responseEntity);

        flightService.getFlights();
    }

    @Test
    public void testAddFlight() {
        FlightAdder flightAdder = new FlightAdder("FL123", 1, 2, Collections.singletonList(1));
        when(restTemplate.postForEntity(eq("http://localhost:8080/flights"), any(FlightAdder.class), any()))
                .thenReturn(ResponseEntity.ok().build());

        flightService.addFlight(flightAdder);
    }

    @Test
    public void testDeleteFlight() {
        flightService.deleteFlight(1);
    }

    @Test
    public void testUpdateFlight() {
        flightService.updateFlight(1, "FL123", 1, 2, Collections.singletonList(1));
    }
}


