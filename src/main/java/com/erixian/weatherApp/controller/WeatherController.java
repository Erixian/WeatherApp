package com.erixian.weatherApp.controller;

import com.erixian.weatherApp.model.WeatherResponse;
import com.erixian.weatherApp.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;


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

    @GetMapping("/weather")
    public String getWeather(@RequestParam String city, Model model) {
        WeatherResponse weatherResponse = this.weatherService.getCurrentWeather(city);
        model.addAttribute("weather", weatherResponse);

        return "home";
    }
}
