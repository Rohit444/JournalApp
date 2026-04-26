package net.engineeringdigest.journalApp.service;

import net.engineeringdigest.journalApp.weather.response.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

    private static final String api_key = "68824960efe95b82107f2e9913f48d11";
    private static  final String api = "https://api.weatherstack.com/forecast?access_key=API_KEY&query=CITY";

    @Autowired
    RestTemplate restTemplate;

    public WeatherResponse getWeather(String city) {
       String finalApi = api.replace("CITY", city).replace("API_KEY", api_key);
        ResponseEntity<WeatherResponse> response = restTemplate.exchange(finalApi, HttpMethod.GET, null, WeatherResponse.class);
        return response.getBody();
    }
}
