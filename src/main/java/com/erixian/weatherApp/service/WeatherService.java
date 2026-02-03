package com.erixian.weatherApp.service;

import com.erixian.weatherApp.exception.CityNotFoundEx;
import com.erixian.weatherApp.model.Coordinates;
import com.erixian.weatherApp.model.Main;
import com.erixian.weatherApp.model.OpenWeatherResponse;
import com.erixian.weatherApp.model.Weather;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Locale;

@Service
public class WeatherService {

    private static final Logger log = LoggerFactory.getLogger(WeatherService.class);

    //add ao properties
    @Value("${weather.api.url}")
    private String apiUrl;

    @Value("${weather.api.key}")
    private String apiKey;

    private final RestTemplate restTemplate;

    // Construtor para injeção do RestTemplate (bean em RestTemplateConfig)
    public WeatherService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;

    }

    public OpenWeatherResponse getCurrentWeather(String lat, String lon) {
        String wholeUrl;
        OpenWeatherResponse openWeatherResponse;

        //https://api.openweathermap.org/data/2.5/weather?lat={lat}&lon={lon}&appid={API key}
        wholeUrl = String.format(Locale.US, "%s?lat=%s&lon=%s&appid=%s&units=metric", apiUrl, lat, lon, apiKey);
        openWeatherResponse = restTemplate.getForObject(wholeUrl, OpenWeatherResponse.class);
        System.out.println(openWeatherResponse.getName());

        ArrayList<Weather> list = openWeatherResponse.getWeather();
        System.out.println(openWeatherResponse.getRain());
        for (Weather weather : list) {
            System.out.println(weather.toString());
        }

        return openWeatherResponse;
    }
}