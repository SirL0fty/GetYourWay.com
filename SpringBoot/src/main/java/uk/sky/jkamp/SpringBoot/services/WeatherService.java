package uk.sky.jkamp.SpringBoot.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class WeatherService {
    @Value("${openWeatherApiKey}")
    private String openWeatherApiKey;

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
}
