package com.erixian.weatherApp.controller;

import com.erixian.weatherApp.exception.CityNotFoundEx;
import com.erixian.weatherApp.model.OpenWeatherResponse;
import com.erixian.weatherApp.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class ApiWeatherController {

    private final WeatherService weatherService;

    @Autowired
    public ApiWeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/weather")
    public ResponseEntity<?> getWeatherJson(@RequestParam(required = false) String city) {
        if (city == null || city.trim().isEmpty()) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Please provide a city name");
        }

        try {
            OpenWeatherResponse weatherResponse = this.weatherService.getCurrentWeather(city.trim());
            return ResponseEntity.ok(weatherResponse);
        } catch (CityNotFoundEx ex) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(ex.getMessage());
        } catch (Exception ex) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error fetching weather data");
        }
    }
}