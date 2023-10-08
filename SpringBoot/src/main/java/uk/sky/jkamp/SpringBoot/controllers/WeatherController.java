package uk.sky.jkamp.SpringBoot.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import uk.sky.jkamp.SpringBoot.services.WeatherService;

@RestController
public class WeatherController {
    private WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    /**
     * An API that retrieves the current weather conditions for a city
     * @param city - The name of the city
     * @return - A JSON object in String format with detailed results of the weather
     */
    @GetMapping("/getCurrentWeatherByCity")
    public String getCurrentWeatherByCity(@RequestParam(value = "city") String city) {
        return this.weatherService.getCurrentWeatherByCity(city);
    }
}
