package com.erixian.weatherApp.model;

import lombok.Data;

@Data
public class WeatherResponse {
    private Location location;
    private Current current;
}