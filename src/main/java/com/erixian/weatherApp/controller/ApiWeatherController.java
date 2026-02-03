package com.erixian.weatherApp.controller;

import com.erixian.weatherApp.exception.CityNotFoundEx;
import com.erixian.weatherApp.model.Coordinates;
import com.erixian.weatherApp.model.OpenWeatherResponse;
import com.erixian.weatherApp.service.GeoCodingService;
import com.erixian.weatherApp.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Minimal REST controller to expose the same weather data as JSON for the React frontend.
 * Endpoint: GET /api/weather?city={cityName}
 *
 * Notes:
 * - Adds simple validation (400 when city is missing).
 * - Returns 404 when CityNotFoundEx is thrown by the service.
 * - Returns 500 for unexpected errors.
 * - CORS enabled for all origins to simplify development with a local React dev server.
 */
@Controller
@RequestMapping("/")
public class ApiWeatherController {

    private  WeatherService weatherService;
    private  GeoCodingService  geoCodingService;

    @Autowired
    public ApiWeatherController(WeatherService weatherService, GeoCodingService  geoCodingService) {
        this.weatherService = weatherService;
        this.geoCodingService = geoCodingService;
    }

    @GetMapping("/")
    public String showHome() {
        return "home";
    }

    @GetMapping("/weather")
    public String getWeatherJson(@RequestParam(required = false) String city,
                                            @RequestParam(required = false) String stateCode,
                                            @RequestParam(required = false) String countryCode,
                                            Model model) {
        Coordinates coordResponse = this.geoCodingService.getCoordinates(city.trim(), stateCode.trim(), countryCode.trim());
        OpenWeatherResponse data = weatherService.getCurrentWeather(coordResponse.getLat(), coordResponse.getLon());
        model.addAttribute("weatherData", data);
        model.addAttribute("coords", coordResponse);

        return "home";
    }
}