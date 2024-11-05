package com.airport.client.Service;

import com.airport.client.Model.*;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
                List<Passenger> passengers = flight.getPassengers();
                for (Passenger passenger : passengers) {
                    System.out.println(passenger.toString());
                }
                System.out.println();
            }
        }
    }

    public void getFlightById(int id){
        String url = "http://localhost:8080/flights/"+id;
        Flight flight = restTemplate.getForObject(url, Flight.class);
        System.out.println(flight.toString());
        List<Passenger> passengers = flight.getPassengers();
        for (Passenger passenger : passengers) {
            System.out.println(passenger.toString());
        }
        System.out.println();
    }

    public void getFlightByPassenger(int id){
        String url = "http://localhost:8080/flights/passenger/"+id;
        Flight flight = restTemplate.getForObject(url, Flight.class);
        System.out.println(flight.toString());
        List<Passenger> passengers = flight.getPassengers();
        for (Passenger passenger : passengers) {
            System.out.println(passenger.toString());
        }
        System.out.println();
    }

    public void addFlight(FlightAdder addedFlight){
        String url = "http://localhost:8080/flights";
        try {
            restTemplate.postForEntity(url, addedFlight, Flight.class);
            System.out.println("Flight Scheduled!");
        } catch (Exception e){
            System.out.println("Flight failed, Error: "+e);
        }
    }

    public void deleteFlight(int id) {
        String url = "http://localhost:8080/flights/"+id;
        try {
            restTemplate.delete(url);
            System.out.println("Flight Cancelled!");
        } catch (Exception e){
            System.out.println("Flight failed, Error: "+e);
        }
    }

    public void updateFlight(int id, String flight_number, int new_origin, int new_destination, List<Integer> new_passengers) {
        try {
            String url = "http://localhost:8080/flights/"+id;

            Map<String, Object> updates = new HashMap<>();
            updates.put("flightNumber", flight_number);
            updates.put("origin_airport_id", new_origin);
            updates.put("destination_airport_id", new_destination);
            updates.put("passengers", new_passengers);

            restTemplate.put(url, updates);

            System.out.println("Flight updated successfully.");
        } catch (Exception e){
            System.out.println("Flight Failed, Error: "+e);
        }
    }
}
