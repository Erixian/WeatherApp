package com.erixian.weatherApp.model;

import lombok.Data;
import org.springframework.context.annotation.Bean;

@Data
public class WeatherResponse {
    private Location location;
    private Current current;
}