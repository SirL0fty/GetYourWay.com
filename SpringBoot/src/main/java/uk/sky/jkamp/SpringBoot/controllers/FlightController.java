package uk.sky.jkamp.SpringBoot.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uk.sky.jkamp.SpringBoot.services.FlightDTO;
import uk.sky.jkamp.SpringBoot.services.FlightService;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/flights")// Specify the base URL
public class FlightController {

    private final FlightService flightService; // Inject the FlightService

    @Autowired
    public FlightController(FlightService flightService) {
        this.flightService = flightService; // Initialise the FlightService
    }

    // Endpoint to get the user's location (example)
    @GetMapping("/user-location")
    public String getUserLocation() {
        // Implement logic to retrieve the user's location (e.g., based on IP address)
        return "User's location: London";
    }

    // Endpoint to search for flights
    @GetMapping("/search") // Specify the endpoint URL
    public List<FlightDTO> searchFlights( // Specify the query parameters
                                          @RequestParam String origin,
                                          @RequestParam String destination,
                                          @RequestParam LocalDate departureDate,
                                          @RequestParam int adults,
                                          @RequestParam int children) {
        // Call the FlightService to get flight information
        return flightService.getFlights(origin, destination, departureDate, adults, children); // Return the flight information
    }

    // Endpoint to book a flight

}
