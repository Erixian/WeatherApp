package com.erixian.weatherApp.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Cloud {
    @JsonProperty("all")
    private int all;

    public Cloud() {
    }

    public int getAll() {
        return all;
    }

    public void setAll(int all) {
        this.all = all;
    }
}
