package uk.sky.jkamp.SpringBoot.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.util.Base64;

@Service
public class WeatherService {
    @Value("${openWeatherApiKey}")
    private String openWeatherApiKey;

    @Value("${meteomaticsUsername}")
    private String meteomaticsUsername;

    @Value("${meteomaticsPassword}")
    private String meteomaticsPassword;

    public WeatherService() {}

    /**
     * Retrieves the current weather conditions for a city
     * @param city - The name of the city
     * @return - A JSON object in String format with detailed results of the weather
     */
    public String getCurrentWeatherByCity(String city) {
        WebClient webClient = WebClient.create("https://api.openweathermap.org/data/2.5/weather?q=" + city + "&APPID=" + openWeatherApiKey);

        return webClient.get()
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }

    /**
     * Retrieves the current weather conditions for a pair of coordinates
     * @param latitude - The latitude of the location
     * @param longitude - The longitude of the location
     * @return - A JSON object in String format with the current weather
     */
    public String getCurrentWeatherByCoordinates(Double latitude, Double longitude) {
        WebClient webClient = WebClient.create("https://api.meteomatics.com/" + Instant.now().toString() + "/t_2m:C/" + latitude + "," + longitude + "/json");
        String credentials = meteomaticsUsername + ":" + meteomaticsPassword;
        String encodedCredentials = Base64.getEncoder().encodeToString(credentials.getBytes(StandardCharsets.UTF_8));

        return webClient.get()
                .headers(httpHeaders -> httpHeaders.setBasicAuth(encodedCredentials))
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }

    /**
     * Retrieves the daily forecasted weather for the current day and three subsequent days
     * @param latitude - The latitude of the location
     * @param longitude - The longitude of the location
     * @return - A JSON object in String format with the weather for the current day and three subsequent days
     */
    public String getDailyForecastedWeatherForFourDays(Double latitude, Double longitude) {
        String startDate = Instant.now().toString();
        String endDate = Instant.now().plusSeconds(259200).toString();

        WebClient webClient = WebClient.create("https://api.meteomatics.com/" + startDate + "--" + endDate + ":PT24H/t_2m:C/" + latitude + "," + longitude + "/json");
        String credentials = meteomaticsUsername + ":" + meteomaticsPassword;
        String encodedCredentials = Base64.getEncoder().encodeToString(credentials.getBytes(StandardCharsets.UTF_8));

        return webClient.get()
                .headers(httpHeaders -> httpHeaders.setBasicAuth(encodedCredentials))
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }
}
