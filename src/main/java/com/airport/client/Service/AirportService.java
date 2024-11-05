package com.airport.client.Service;

import com.airport.client.Model.Airport;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AirportService {

    private final RestTemplate restTemplate;

    public AirportService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    public void getAirports(){
        ResponseEntity<List<Airport>> response = restTemplate.exchange(
                "http://localhost:8080/airports",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Airport>>() {}
        );
        List<Airport> airports = response.getBody();
        if (airports != null) {
            for (Airport airport : airports) {
                System.out.println(airport.toString());
            }
        }
    }

    public void getAirportById(int id){
        String url = "http://localhost:8080/airports/"+id;
        Airport airport = restTemplate.getForObject(url, Airport.class);
        System.out.println(airport.toString());
    }

    public void addAirport(Airport addedAirport){
        String url = "http://localhost:8080/airports";
        try {
            restTemplate.postForEntity(url, addedAirport, Airport.class);
            System.out.println("Airport Added!");
        } catch (Exception e){
            System.out.println("Airport Failed, Error: "+e);
        }
    }

    public void deleteAirport(int id) {
        String url = "http://localhost:8080/airports/"+id;
        try {
            restTemplate.delete(url);
            System.out.println("Airport Removed!");
        } catch (Exception e){
            System.out.println("Airport Failed, Error: "+e);
        }
    }

    public void updateAirport(int id, String new_name, String new_code) {
        try {
            String url = "http://localhost:8080/airports/" + id;

            Map<String, Object> updates = new HashMap<>();
            updates.put("airport_name", new_name);
            updates.put("code", new_code);

            restTemplate.put(url, updates);

            System.out.println("Airport updated successfully.");
        } catch (Exception e){
            System.out.println("Airport Failed, Error: "+e);
        }
    }
}
