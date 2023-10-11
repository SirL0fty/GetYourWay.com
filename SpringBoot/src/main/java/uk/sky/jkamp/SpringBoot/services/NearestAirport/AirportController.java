package uk.sky.jkamp.SpringBoot.services.NearestAirport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import uk.sky.jkamp.SpringBoot.services.AirportService;

import java.util.List;

@RestController
public class AirportController {
    private final AirportService airportService;

    @Autowired
    public AirportController(AirportService airportService) {
        this.airportService = airportService;
    }

    @GetMapping("/nearest-airports")
    public List<AirportResponse> getNearestRelevantAirports(
            @RequestParam String latitude,
            @RequestParam String longitude,
            @RequestParam String radius) throws Exception {
        return airportService.getNearestRelevantAirports(latitude, longitude, radius);
    }
}
