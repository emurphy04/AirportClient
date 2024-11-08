package com.airport.client.Service;

import com.airport.client.Model.Airport;
import com.airport.client.Model.Flight;
import com.airport.client.Model.FlightAdder;
import com.airport.client.Model.Passenger;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PassengerService {
    private final RestTemplate restTemplate;

    public PassengerService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    public void getPassengers(){
        ResponseEntity<List<Passenger>> response = restTemplate.exchange(
                "http://localhost:8080/passengers",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Passenger>>() {}
        );
        List<Passenger> passengers = response.getBody();
        if (passengers != null) {
            for (Passenger passenger : passengers) {
                System.out.println(passenger.toString());
            }
        }
    }

    public void getPassengerById(int id){
        String url = "http://localhost:8080/passengers/"+id;
        Passenger passenger = restTemplate.getForObject(url, Passenger.class);
        System.out.println(passenger.toString());

    }

    public void addPassenger(Passenger addedPassenger){
        String url = "http://localhost:8080/passengers";
        try {
            restTemplate.postForEntity(url, addedPassenger, Passenger.class);
            System.out.println("Passenger added!");
        } catch (Exception e){
            System.out.println("Passenger failed, Error: "+e);
        }
    }

    public void deletePassenger(int id) {
        String url = "http://localhost:8080/passengers/"+id;
        try {
            restTemplate.delete(url);
            System.out.println("Passenger Removed!");
        } catch (Exception e){
            System.out.println("Passenger failed, Error: "+e);
        }
    }

    public void updatePassenger(int id, String firstName, String lastName, String phoneNumber) {
        try {
            String url = "http://localhost:8080/passengers/"+id;

            Map<String, Object> updates = new HashMap<>();
            updates.put("first_name", firstName);
            updates.put("last_name", lastName);
            updates.put("phone_number", phoneNumber);

            restTemplate.put(url, updates);

            System.out.println("Passenger updated successfully.");
        } catch (Exception e){
            System.out.println("Passenger Failed, Error: "+e);
        }
    }
}
