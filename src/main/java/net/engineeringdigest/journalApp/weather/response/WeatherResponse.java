package net.engineeringdigest.journalApp.weather.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WeatherResponse {
    private Current current;

    @Getter
    @Setter
    public static class Current{
        @JsonProperty("observation_time")
        private String observationTime;
        private int temperature;
        @JsonProperty("wind_speed")
        private int windSpeed;
        @JsonProperty("wind_degree")
        private int windDegree;
        @JsonProperty("wind_dir")
        private String windDir;
    }
}







