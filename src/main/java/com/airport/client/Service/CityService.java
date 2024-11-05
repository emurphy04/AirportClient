package com.airport.client.Service;

import com.airport.client.Model.Airport;
import com.airport.client.Model.City;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CityService {

    private final RestTemplate restTemplate;

    public CityService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    public void getCities(){
        ResponseEntity<List<City>> response = restTemplate.exchange(
                "http://localhost:8080/cities",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<City>>() {}
        );
        List<City> cities = response.getBody();
        if (cities != null) {
            for (City city : cities) {
                System.out.println(city.toString());
            }
        }
    }

    public void getCityById(int id){
        String url = "http://localhost:8080/cities/"+id;
        City city = restTemplate.getForObject(url, City.class);
        System.out.println(city.toString());

    }

    public void addCity(City addedCity){
        String url = "http://localhost:8080/cities";
        try {
            restTemplate.postForEntity(url, addedCity, City.class);
            System.out.println("City Added!");
        } catch (Exception e){
            System.out.println("City Failed, Error: "+e);
        }
    }

    public void deleteCity(int id) {
        String url = "http://localhost:8080/cities/"+id;
        try {
            restTemplate.delete(url);
            System.out.println("City Removed!");
        } catch (Exception e){
            System.out.println("City Failed, Error: "+e);
        }
    }

    public void updateCity(int id, String new_name, String new_province, int new_population, int new_airport_id) {
        try {
            String url = "http://localhost:8080/cities/" + id;

            Map<String, Object> updates = new HashMap<>();
            updates.put("name", new_name);
            updates.put("province", new_province);
            updates.put("population", new_population);
            updates.put("airport_id", new_airport_id);

            restTemplate.put(url, updates);

            System.out.println("City updated successfully.");
        } catch (Exception e){
            System.out.println("City Failed, Error: "+e);
        }
    }
}
