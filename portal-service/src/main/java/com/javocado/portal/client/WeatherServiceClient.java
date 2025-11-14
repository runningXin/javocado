package com.javocado.portal.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.json.JSONObject;

@Service
public class WeatherService {

    @Value("${weather.api.key}")
    private String apiKey;

    public String getWeather() {
        String city = "Cupertino";
        String url = "https://api.openweathermap.org/data/2.5/weather?q=" + city +
                "&appid=" + apiKey + "&units=metric";

        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(url, String.class);

        JSONObject json = new JSONObject(response);
        String description = json.getJSONArray("weather").getJSONObject(0).getString("description");
        double temp = json.getJSONObject("main").getDouble("temp");

        return description + ", " + temp + "°C";
    }
}