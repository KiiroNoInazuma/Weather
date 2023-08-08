package com.app.weather.model;

import lombok.Data;


@Data
public class Weather {
    private WeatherMain main;
    private WeatherWind wind;

    @Override
    public String toString() {
        return main + " " + wind;
    }

    @Data
    public static class WeatherMain {
        private float temp;
        private int humidity;

        @Override
        public String toString() {
            return "Температура: " + temp +
                    "\nВлажность: " + humidity;
        }
    }

    @Data
    public static class WeatherWind {
        private float speed;
        private int deg;

        @Override
        public String toString() {
            return "\nСкорость ветра: " + speed +
                    "\nУказатель направления ветра: " + deg;
        }
    }
}
