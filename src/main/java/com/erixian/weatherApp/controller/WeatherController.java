package com.erixian.weatherApp.controller;

import com.erixian.weatherApp.model.WeatherResponse;
import com.erixian.weatherApp.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class WeatherController {

    private final WeatherService weatherService;

    @Autowired
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @ResponseBody
    @RequestMapping("weather/{city}")
    public WeatherResponse getWeather(@PathVariable String city) {
        return this.weatherService.getCurrentWeather(city);
    }
}
