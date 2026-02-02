package com.erixian.weatherApp.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Sys {
    private int type;
    private int id;
    private String country;
    private int sunrise;
    private int sunset;

    public Sys() {
    }

    @JsonProperty("type")
    public int getType() {
        return this.type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @JsonProperty("id")
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @JsonProperty("country")
    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @JsonProperty("sunrise")
    public int getSunrise() {
        return this.sunrise;
    }

    public void setSunrise(int sunrise) {
        this.sunrise = sunrise;
    }

    @JsonProperty("sunset")
    public int getSunset() {
        return this.sunset;
    }

    public void setSunset(int sunset) {
        this.sunset = sunset;
    }
}
