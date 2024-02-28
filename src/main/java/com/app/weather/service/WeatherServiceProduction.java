package com.app.weather.service;

import com.app.weather.model.Weather;
import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Profile("!production")
public class WeatherServiceProduction implements WeatherService{

    Logger logger = LoggerFactory.getLogger(WeatherServiceProduction.class);
    @Value("${weather.url}")
    private String apiWeather;
    @Resource
    private RestTemplate restTemplate;

    public Weather getWeather(String city) {
        logger.debug("Лог: {}", city);

        Weather weather = restTemplate
                .exchange(apiWeather,
                        HttpMethod.GET,
                        new HttpEntity<>(HttpHeaders.EMPTY),
                        Weather.class,
                        city).getBody();
        logger.debug("Лог: {} и {}", city, weather);
        return weather;
    }

}
