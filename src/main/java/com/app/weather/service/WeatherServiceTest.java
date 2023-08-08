package com.app.weather.service;

import com.app.weather.model.Weather;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("!production")
public class WeatherServiceTest implements WeatherService {

    @Override
    public Weather getWeather(String city) {
        Weather weather = new Weather();
        Weather.WeatherMain weatherMain = new Weather.WeatherMain();
        weatherMain.setTemp(1.00f);
        weatherMain.setHumidity(23);
        Weather.WeatherWind weatherWind = new Weather.WeatherWind();
        weatherWind.setSpeed(1.00f);
        weatherWind.setDeg(12);
        weather.setMain(weatherMain);
        weather.setWind(weatherWind);
        return weather;
    }
}
