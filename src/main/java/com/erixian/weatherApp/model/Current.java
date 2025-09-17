package com.erixian.weatherApp.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Current {

    @JsonProperty("temp_c")
    private double tempC;

    @JsonProperty("is_day")
    private boolean isDay;

    @JsonProperty("wind_kph")
    private double windKph;

    @JsonProperty("wind_dir")
    private String windDir;

    @JsonProperty("precip_mm")
    private double precipMm;

    @JsonProperty("humidity")
    private int humidity;

    @JsonProperty("feelslike_c")
    private double feelsLikeC;

    @JsonProperty("uv")
    private double uv;
}
