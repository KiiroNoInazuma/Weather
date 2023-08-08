package com.app.weather.service;

import com.app.weather.model.Weather;
import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Profile("production")
public class WeatherServiceProduction implements WeatherService{
    private static final String WEATHER_SERVICE_URL =
            "https://api.openweathermap.org/data/2.5/weather?q={city}&units=metric&appid=2edd52f5fd11fd3367e045b6346bfb59";
    Logger logger = LoggerFactory.getLogger(WeatherServiceProduction.class);
    @Resource
    private RestTemplate restTemplate;

    public Weather getWeather(String city) {
        logger.debug("Лог: {}", city);

        Weather weather = restTemplate
                .exchange(WEATHER_SERVICE_URL,
                        HttpMethod.GET,
                        new HttpEntity<>(HttpHeaders.EMPTY),
                        Weather.class,
                        city).getBody();
        logger.debug("Лог: {} и {}", city, weather);
        return weather;
    }

}
