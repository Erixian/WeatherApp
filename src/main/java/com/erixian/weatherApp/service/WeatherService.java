package com.erixian.weatherApp.service;


import com.erixian.weatherApp.exception.CityNotFoundEx;
import com.erixian.weatherApp.model.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService extends MappingJackson2HttpMessageConverter {

    @Value("${weather.api.url}")
    private String apiUrl;

    @Value("${weather.api.key}")
    private String apiKey;

    private WeatherService() {
        setPrettyPrint(true);
    }

    public WeatherResponse getCurrentWeather(String city) {

            RestTemplate restTemplate = new RestTemplate();
            String wholeUrl = String.format("%s?key=%s&q=%s&aqi=no", apiUrl, apiKey, city);

            try {
                return restTemplate.getForObject(wholeUrl, WeatherResponse.class);
            } catch (HttpClientErrorException.BadRequest ex) {
                throw new CityNotFoundEx("City '" + city + "' not founded", ex);
            } catch (HttpClientErrorException.NotFound ex) {
                throw new CityNotFoundEx("City not founded", ex);
            } catch (Exception ex) {
                throw new RuntimeException("Error fetching weather for '" + city + "'", ex);
            }
    }
}
