package com.erixian.weatherApp.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class OpenWeatherResponse {
    @JsonProperty("timezone")
    private int timezone;
    @JsonProperty("id")
    private long id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("cod")
    private int cod;

    @JsonProperty("clouds")
    private Cloud clouds;
    @JsonProperty("sys")
    private Sys sys;
    @JsonProperty("main")
    private Main main;
    @JsonProperty("rain")
    private Rain rain;
    @JsonProperty("weather")
    private ArrayList<Weather> weather;
    @JsonProperty("coord")
    private Coordinates coord;

    public OpenWeatherResponse() {
    }

    public Cloud getClouds() {
        return clouds;
    }

    public void setClouds(Cloud cloud) {
        this.clouds = cloud;
    }

    public Sys getSys() {
        return sys;
    }

    public void setSys(Sys sys) {
        this.sys = sys;
    }

    public int getTimezone() {
        return timezone;
    }

    public void setTimezone(int timezone) {
        this.timezone = timezone;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public Rain getRain() {
        return rain;
    }

    public void setRain(Rain rain) {
        this.rain = rain;
    }

    public ArrayList<Weather> getWeather() {
        return this.weather; }

    public void setWeather(ArrayList<Weather> weather) {
        this.weather = weather; }

    public Coordinates getCoord() {
        return coord;
    }

    public void setCoord(Coordinates coord) {
        this.coord = coord;
    }
}