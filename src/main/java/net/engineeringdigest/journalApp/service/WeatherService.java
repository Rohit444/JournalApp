package net.engineeringdigest.journalApp.service;

import net.engineeringdigest.journalApp.cache.AppCache;
import net.engineeringdigest.journalApp.weather.response.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

    @Value("${weather.forecast.api-key}")
    private String API_KEY;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    AppCache appCache;

    public WeatherResponse getWeather(String city) {
       String finalApi = appCache.appCache.get(AppCache.keys.WEATHER_API.toString()).replace("<city>", city).replace("<apiKey>", API_KEY);
        ResponseEntity<WeatherResponse> response = restTemplate.exchange(finalApi, HttpMethod.GET, null, WeatherResponse.class);
        return response.getBody();
    }
}
