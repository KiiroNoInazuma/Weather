package com.app.weather.model;

import lombok.Data;

@Data
public class Weather {
    private WeatherMain main;
    private WeatherWind wind;


    @Data
    static class WeatherMain {
        private float temp;
        private int humidity;


    }

    @Data
    static class WeatherWind {
        private float speed;
        private int deg;
    }
}
