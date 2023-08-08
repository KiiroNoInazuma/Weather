package com.app.weather.model;

import lombok.Data;

@Data
public class Weather {
    private WeatherMain main;
    private WeatherWind wind;


    @Data
    public static class WeatherMain {
        private float temp;
        private int humidity;


    }

    @Data
    public static class WeatherWind {
        private float speed;
        private int deg;
    }
}
