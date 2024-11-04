package com.airport.client.Model;

public class City {
    private int city_id;
    private String name;
    private String province;
    private int population;
    private Airport airport;
    private int airport_id;

    public City(){

    }

    public City(String name, String province, int population, int airport_id) {
        this.name = name;
        this.province = province;
        this.population = population;
        this.airport_id = airport_id;
    }

    public City(String name, String province, int population, Airport airport) {
        this.name = name;
        this.province = province;
        this.population = population;
        this.airport = airport;
    }

    public City(int city_id, String name, String province, int population, Airport airport) {
        this.city_id = city_id;
        this.name = name;
        this.province = province;
        this.population = population;
        this.airport = airport;
    }

    public int getCity_id() {
        return city_id;
    }

    public void setCity_id(int city_id) {
        this.city_id = city_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public Airport getAirport() {
        return airport;
    }

    public void setAirport(Airport airport) {
        this.airport = airport;
    }

    public int getAirport_id() {
        return airport_id;
    }

    public void setAirport_id(int airport_id) {
        this.airport_id = airport_id;
    }

    @Override
    public String toString() {
        return "City ID: "+city_id+" | City: "+name+", "+province+" | Population: "+population+" | Airport: "+airport.toString();
    }
}
