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

    /**
     * An API that retrieves the current weather conditions for a pair of coordinates
     * @param latitude - The latitude of the location
     * @param longitude - The longitude of the location
     * @return - A JSON object in String format with the current weather
     */
    @GetMapping("/getCurrentWeatherByCoordinates")
    public String getCurrentWeatherByCoordinates(@RequestParam(value = "latitude") Double latitude, @RequestParam(value = "longitude") Double longitude) {
        return this.weatherService.getCurrentWeatherByCoordinates(latitude, longitude);
    }

    /**
     * An API that retrieves the forecasted weather for the current day and three subsequent days
     * @param latitude - The location latitude
     * @param longitude - The location longitude
     * @return - A JSON object in String format with the weather for the current day and three subsequent days
     */
    @GetMapping("/getDailyForecastedWeather")
    public String getDailyForecastedWeatherForFourDays(@RequestParam(value = "latitude") Double latitude, @RequestParam(value = "longitude") Double longitude) {
        return this.weatherService.getDailyForecastedWeatherForFourDays(latitude, longitude);
    }
}
