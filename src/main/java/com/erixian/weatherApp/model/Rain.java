package com.erixian.weatherApp.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Rain {
    @JsonProperty("1h")
    private double lh;

    public Rain() {
    }

    public double getLh() {
        return lh;
    }

    public void setLh(double lh) {
        this.lh = lh;
    }
}
