package com.app.weather.controller;

import com.app.weather.model.Weather;
import com.app.weather.service.WeatherService;
import jakarta.annotation.Resource;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherController {

    @Resource
    private WeatherService weatherService;
    @Resource
    private ConfigurableApplicationContext context;

    @CrossOrigin
    @GetMapping("weather/{city}")
    public ResponseEntity<Weather> getWeather(@PathVariable String city) {
        Weather weather = weatherService.getWeather(city);
        return ResponseEntity.ok(weather);
    }

    @GetMapping("/exit")
    public void closeApplication() {
        context.close();


    }

}
