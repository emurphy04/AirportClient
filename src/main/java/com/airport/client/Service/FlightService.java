package com.airport.client.Service;

import com.airport.client.Model.City;
import com.airport.client.Model.Flight;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class FlightService {

    private final RestTemplate restTemplate;

    public FlightService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    public void getFlights(){
        ResponseEntity<List<Flight>> response = restTemplate.exchange(
                "http://localhost:8080/flights",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Flight>>() {}
        );
        List<Flight> flights = response.getBody();
        if (flights != null) {
            for (Flight flight : flights) {
                System.out.println(flight.toString());
            }
        }
    }

    public void getFlightById(int id){
        String url = "http://localhost:8080/flights/"+id;
        Flight flight = restTemplate.getForObject(url, Flight.class);
        System.out.println(flight.toString());
    }

    public void getFlightByPassenger(int id){
        String url = "http://localhost:8080/flights/passenger/"+id;
        Flight flight = restTemplate.getForObject(url, Flight.class);
        System.out.println(flight.toString());
    }
}
