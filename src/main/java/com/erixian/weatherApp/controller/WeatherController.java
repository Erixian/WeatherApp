package com.erixian.weatherApp.controller;

import com.erixian.weatherApp.model.WeatherResponse;
import com.erixian.weatherApp.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherController {

    private final WeatherService weatherService;

    @Autowired
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @RequestMapping("/")
    String home() {
        return "Welcome to Weather App";
    }

    @RequestMapping("weather/{city}")
    public WeatherResponse getWeather(@PathVariable String city) {
        return this.weatherService.getCurrentWeather(city);
    }
}
