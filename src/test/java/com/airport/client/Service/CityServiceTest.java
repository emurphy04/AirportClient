package com.airport.client.Service;

import com.airport.client.Model.City;
import com.airport.client.Service.CityService;
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
public class CityServiceTest {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private CityService cityService;

    @Test
    public void testGetCities() {
        ResponseEntity<List<City>> responseEntity = ResponseEntity.ok(Collections.emptyList());
        when(restTemplate.exchange(
                eq("http://localhost:8080/cities"),
                eq(HttpMethod.GET),
                any(),
                eq(new ParameterizedTypeReference<List<City>>() {})
        )).thenReturn(responseEntity);

        cityService.getCities();
    }

    @Test
    public void testAddCity() {
        when(restTemplate.postForEntity(eq("http://localhost:8080/cities"), any(City.class), eq(City.class)))
                .thenReturn(ResponseEntity.ok(new City("New City", "Province", 2000, 1)));

        cityService.addCity(new City("New City", "Province", 2000, 1));
    }

    @Test
    public void testDeleteCity() {
        cityService.deleteCity(1);
    }

    @Test
    public void testUpdateCity() {
        cityService.updateCity(1, "Updated City", "Province", 1500, 2);
    }
}


