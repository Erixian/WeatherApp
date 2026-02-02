package com.erixian.weatherApp.service;

import com.erixian.weatherApp.model.Coordinates;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ResourceBundle;

@Service
public class GeoCodingService {
    @Value("${geocoding.api.url}")
    private String apiUrl;

    @Value("${weather.api.key}")
    private String apiKey;

    @Value("${geocoding.api.limit}")
    private int limit;

    private final RestTemplate restTemplate;

    public GeoCodingService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Coordinates getCoordinates(String city, String stateCode, String countryCode) {
        String wholeUrl;
        Coordinates[] coordResponse;

        if(apiUrl == null || apiUrl.trim().isEmpty()) {
            throw new IllegalArgumentException("API URL not configures");
        }

        http://api.openweathermap.org/geo/1.0/direct?q={city name},{state code},{country code}&limit={limit}&appid={API key}
        wholeUrl = String.format("%s?q=%s,%s,%s&limit=%d&appid=%s", apiUrl,city, stateCode, countryCode, limit, apiKey);
        System.out.println(wholeUrl);

        coordResponse = restTemplate.getForObject(wholeUrl, Coordinates[].class);
        if(coordResponse.length == 0) {
            throw new RuntimeException("No coords found for: " + city);
        }
        else {
            System.out.println(coordResponse.toString());
        }

        Coordinates firstResult = coordResponse[0];

        System.out.println("Latitude: " + firstResult.getLat());
        System.out.println("Longitude: " + firstResult.getLon());

        return firstResult;
    }

    //http://api.openweathermap.org/geo/1.0/direct?q=Sorocaba,SP,BR&limit=1&appid=dee7a194025e0b5977864eaf7c841b38

}
