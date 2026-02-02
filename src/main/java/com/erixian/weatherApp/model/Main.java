package com.erixian.weatherApp.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Main {

    private double temp;
    private double feelsLike;
    private double tempMin;
    private double tempMax;
    private int pressure;
    private int humidity;
    private int seaLevel;
    private int grndLevel;

    public Main() {
    }

    @JsonProperty("temp")
    public double getTemp() {
        return this.temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    @JsonProperty("feels_like")
    public double getFeelsLike() {
        return this.feelsLike;
    }

    public void setFeelsLike(double feelsLike) {
        this.feelsLike = feelsLike;
    }

    @JsonProperty("temp_min")
    public double getTempMin() {
        return this.tempMin;
    }

    public void setTempMin(double tempMin) {
        this.tempMin = tempMin;
    }

    @JsonProperty("temp_max")
    public double getTempMax() {
        return this.tempMax;
    }

    public void setTempMax(double tempMax) {
        this.tempMax = tempMax;
    }

    @JsonProperty("pressure")
    public int getPressure() {
        return this.pressure;
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
    }

    @JsonProperty("humidity")
    public int getHumidity() {
        return this.humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    @JsonProperty("sea_level")
    public int getSeaLevel() {
        return this.seaLevel;
    }

    public void setSeaLevel(int seaLevel) {
        this.seaLevel = seaLevel;
    }

    @JsonProperty("grnd_level")
    public int getGrndLevel() {
        return this.grndLevel;
    }

    public void setGrndLevel(int grndLevel) {
        this.grndLevel = grndLevel;
    }
}
