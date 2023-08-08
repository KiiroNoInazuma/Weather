package com.app.weather.service;

import com.app.weather.model.Weather;
import jakarta.annotation.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {
    private static final String WEATHER_SERVICE_URL = "https://api.openweathermap.org/data/2.5/weather?q={city}&units=metric&appid=2edd52f5fd11fd3367e045b6346bfb59";
    @Resource
    private RestTemplate restTemplate;

    public Weather getWeather(String city) {
        return restTemplate
                .exchange(WEATHER_SERVICE_URL,
                        HttpMethod.GET,
                        new HttpEntity<>(HttpHeaders.EMPTY),
                        Weather.class,
                        city).getBody();
    }

}
