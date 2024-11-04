package com.airport.client.Model;

import java.util.List;

public class FlightAdder {
    private String flightNumber;
    private int origin_airport_id;
    private int destination_airport_id;
    private List<Integer> passengers;

    public FlightAdder(){}

    public FlightAdder(String flightNumber, int origin_airport_id, int destination_airport_id, List<Integer> passengers) {
        this.flightNumber = flightNumber;
        this.origin_airport_id = origin_airport_id;
        this.destination_airport_id = destination_airport_id;
        this.passengers = passengers;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public int getOrigin_airport_id() {
        return origin_airport_id;
    }

    public void setOrigin_airport_id(int origin_airport_id) {
        this.origin_airport_id = origin_airport_id;
    }

    public int getDestination_airport_id() {
        return destination_airport_id;
    }

    public void setDestination_airport_id(int destination_airport_id) {
        this.destination_airport_id = destination_airport_id;
    }

    public List<Integer> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<Integer> passengers) {
        this.passengers = passengers;
    }
}
