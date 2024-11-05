package com.airport.client.Service;

import com.airport.client.Model.Passenger;
import com.airport.client.Service.PassengerService;
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
public class PassengerServiceTest {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private PassengerService passengerService;

    @Test
    public void testGetPassengers() {
        ResponseEntity<List<Passenger>> responseEntity = ResponseEntity.ok(Collections.emptyList());
        when(restTemplate.exchange(
                eq("http://localhost:8080/passengers"),
                eq(HttpMethod.GET),
                any(),
                eq(new ParameterizedTypeReference<List<Passenger>>() {})
        )).thenReturn(responseEntity);

        passengerService.getPassengers();
    }

    @Test
    public void testAddPassenger() {
        when(restTemplate.postForEntity(eq("http://localhost:8080/passengers"), any(Passenger.class), any()))
                .thenReturn(ResponseEntity.ok().build());

        passengerService.addPassenger(new Passenger("John", "Doe", "123-456-7890"));
    }

    @Test
    public void testDeletePassenger() {
        passengerService.deletePassenger(1);
    }

    @Test
    public void testUpdatePassenger() {
        passengerService.updatePassenger(1, "Jane", "Doe", "987-654-3210");
    }
}


