package com.erixian.weatherApp.exception;

public class CityNotFoundEx extends RuntimeException {
    public CityNotFoundEx(String message) {
        super(message);
    }

    public CityNotFoundEx(String message, Throwable cause) {
        super(message, cause);
    }
}
