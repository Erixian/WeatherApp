package com.erixian.weatherApp.service;

import com.erixian.weatherApp.exception.CityNotFoundEx;
import com.erixian.weatherApp.model.OpenWeatherResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

/**
 * Serviço responsável por consultar a API externa de clima.
 *
 * Alterações principais:
 * - Não estende mais MappingJackson2HttpMessageConverter.
 * - Usa RestTemplate injetado (bean configurado em RestTemplateConfig).
 * - Remove instanciação local de RestTemplate, permitindo reuse/testes.
 * - Tratamento explícito de erros (400/404 -> CityNotFoundEx).
 */
@Service
public class WeatherService {

    private static final Logger log = LoggerFactory.getLogger(WeatherService.class);

    @Value("${weather.api.url}")
    private String apiUrl;

    @Value("${weather.api.key}")
    private String apiKey;

    private final RestTemplate restTemplate;

    // Construtor para injeção do RestTemplate (bean em RestTemplateConfig)
    public WeatherService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /**
     * Busca o clima atual para a cidade informada chamando a API externa.
     *
     * @param city nome da cidade
     * @return WeatherResponse populado a partir do JSON da API externa
     * @throws CityNotFoundEx quando a API retorna 400/404 para a cidade
     */
    public OpenWeatherResponse getCurrentWeather(String city) {
        String wholeUrl = String.format("%s?key=%s&q=%s&aqi=no", apiUrl, apiKey, city);
        try {
            log.debug("Requesting weather from URL: {}", wholeUrl);
            OpenWeatherResponse response = restTemplate.getForObject(wholeUrl, OpenWeatherResponse.class);
            if (response == null) {
                throw new RuntimeException("Empty response from weather API for city: " + city);
            }
            return response;
        } catch (HttpClientErrorException ex) {
            HttpStatus status = (HttpStatus) ex.getStatusCode();
            log.warn("Weather API returned error for city '{}': status {} - {}", city, status.value(), ex.getMessage());
            if (status == HttpStatus.BAD_REQUEST || status == HttpStatus.NOT_FOUND) {
                throw new CityNotFoundEx("City '" + city + "' not found", ex);
            }
            throw new RuntimeException("Error fetching weather for '" + city + "': " + ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("Unexpected error while fetching weather for '{}': {}", city, ex.getMessage(), ex);
            throw new RuntimeException("Error fetching weather for '" + city + "'", ex);
        }
    }
}