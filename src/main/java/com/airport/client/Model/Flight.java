package com.airport.client.Model;

import java.util.ArrayList;
import java.util.List;

public class Flight {
    private int flight_id;
    private String flightNumber;
    private Airport origin;
    private Airport destination;
    private List<Passenger> passengers = new ArrayList<>();

    public Flight(){}

    public Flight(int flight_id, String flightNumber, Airport origin, Airport destination, List<Passenger> passengers) {
        this.flight_id = flight_id;
        this.flightNumber = flightNumber;
        this.origin = origin;
        this.destination = destination;
        this.passengers = passengers;
    }

    public int getFlight_id() {
        return flight_id;
    }

    public void setFlight_id(int flight_id) {
        this.flight_id = flight_id;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public Airport getOrigin() {
        return origin;
    }

    public void setOrigin(Airport origin) {
        this.origin = origin;
    }

    public Airport getDestination() {
        return destination;
    }

    public void setDestination(Airport destination) {
        this.destination = destination;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "flight_id=" + flight_id +
                ", flightNumber='" + flightNumber + '\'' +
                ", origin=" + origin +
                ", destination=" + destination +
                ", passengers=" + passengers +
                '}';
    }
}
