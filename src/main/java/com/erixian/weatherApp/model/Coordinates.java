package com.erixian.weatherApp.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;


public class Coordinates {
    @JsonProperty("name")
    private String name;
    @JsonProperty("lon")
    private String lon;
    @JsonProperty("lat")
    private String lat;

    public Coordinates() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }
}
