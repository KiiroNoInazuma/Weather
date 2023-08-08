package com.app.weather.service;

import com.app.weather.model.Weather;

public interface WeatherService {
    Weather getWeather(String city);
}
