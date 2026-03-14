package com.erixian.weatherApp.controller;

import com.erixian.weatherApp.exception.CityNotFoundEx;
import com.erixian.weatherApp.model.Coordinates;
import com.erixian.weatherApp.model.OpenWeatherResponse;
import com.erixian.weatherApp.service.GeoCodingService;
import com.erixian.weatherApp.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

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
                                 @RequestParam(required = false) Integer clientTzOffsetMinutes,
                                 Model model) {
        if (city == null || city.trim().isEmpty()) {
            model.addAttribute("errorMessage", "Por favor informe o nome da cidade.");
            return "home";
        }

        try {
            String cityTrimmed = city.trim();
            String stateTrimmed = stateCode == null ? "" : stateCode.trim();
            String countryTrimmed = countryCode == null ? "" : countryCode.trim();

            Coordinates coordResponse = this.geoCodingService.getCoordinates(cityTrimmed, stateTrimmed, countryTrimmed);
            OpenWeatherResponse data = weatherService.getCurrentWeather(coordResponse.getLat(), coordResponse.getLon());

            DateTimeFormatter gmtFormatter = DateTimeFormatter.ofPattern("HH:mm 'GMT'").withZone(ZoneOffset.UTC);
            String sunriseGmt = gmtFormatter.format(Instant.ofEpochSecond(data.getSys().getSunrise()));
            String sunsetGmt = gmtFormatter.format(Instant.ofEpochSecond(data.getSys().getSunset()));

            int locationOffsetSeconds = data.getTimezone();
            ZoneOffset locationOffset = ZoneOffset.ofTotalSeconds(locationOffsetSeconds);
            DateTimeFormatter localFormatter = DateTimeFormatter.ofPattern("HH:mm 'GMT'xxx").withZone(locationOffset);
            String sunriseLocal = localFormatter.format(Instant.ofEpochSecond(data.getSys().getSunrise()));
            String sunsetLocal = localFormatter.format(Instant.ofEpochSecond(data.getSys().getSunset()));

            String locationZone = "GMT" + formatZoneOffset(locationOffset);

            String clientZone = "unknown";
            String delta = "N/A";
            if (clientTzOffsetMinutes != null) {
                int clientOffsetSeconds = -clientTzOffsetMinutes * 60;
                ZoneOffset clientOffset = ZoneOffset.ofTotalSeconds(clientOffsetSeconds);
                clientZone = "GMT" + formatZoneOffset(clientOffset);
                int diffMinutes = (locationOffsetSeconds - clientOffsetSeconds) / 60;
                delta = (diffMinutes >= 0 ? "+" : "") + (diffMinutes / 60) + "h";
            }

            model.addAttribute("weatherData", data);
            model.addAttribute("coords", coordResponse);
            model.addAttribute("sunriseGmt", sunriseGmt);
            model.addAttribute("sunsetGmt", sunsetGmt);
            model.addAttribute("sunriseLocal", sunriseLocal);
            model.addAttribute("sunsetLocal", sunsetLocal);
            model.addAttribute("locationZone", locationZone);
            model.addAttribute("clientZone", clientZone);
            model.addAttribute("offsetDiff", delta);
            model.addAttribute("cityName", cityTrimmed);

            return "home";
        } catch (CityNotFoundEx ex) {
            model.addAttribute("errorMessage", ex.getMessage());
            return "home";
        } catch (Exception ex) {
            model.addAttribute("errorMessage", "Não foi possível buscar o clima. Tente novamente.");
            return "home";
        }
    }

    private String formatZoneOffset(ZoneOffset zoneOffset) {
        int totalSeconds = zoneOffset.getTotalSeconds();
        int absHours = Math.abs(totalSeconds / 3600);
        int absMinutes = Math.abs((totalSeconds % 3600) / 60);
        return String.format("%s%02d:%02d", totalSeconds >= 0 ? "+" : "-", absHours, absMinutes);
    }
}