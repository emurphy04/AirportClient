package com.airport.client.Model;

public class Airport {
    private int airport_id;
    private String airport_name;
    private String code;

    public Airport(){}

    public Airport(String airport_name, String code){
        this.airport_name = airport_name;
        this.code = code;
    }

    public Airport(int airport_id, String airport_name, String code) {
        this.airport_id = airport_id;
        this.airport_name = airport_name;
        this.code = code;
    }

    public int getAirport_id() {
        return airport_id;
    }

    public void setAirport_id(int airport_id) {
        this.airport_id = airport_id;
    }

    public String getAirport_name() {
        return airport_name;
    }

    public void setAirport_name(String airport_name) {
        this.airport_name = airport_name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Airport ID: "+airport_id+" | Airport Name: "+airport_name+" | Airport Code: "+code;
    }
}
