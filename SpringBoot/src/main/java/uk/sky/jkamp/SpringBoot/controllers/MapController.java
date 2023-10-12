package uk.sky.jkamp.SpringBoot.controllers;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uk.sky.jkamp.SpringBoot.Location;
import com.google.maps.model.TravelMode;
import uk.sky.jkamp.SpringBoot.services.MapService;

@Slf4j
@Controller
public class MapController {

    private final MapService mapService;

    @Autowired
    public MapController(MapService mapService) {
        this.mapService = mapService;
    }

    @GetMapping("/distance")
    public String calculateDistance(
            @RequestParam double originLat,
            @RequestParam double originLng,
            @RequestParam double destLat,
            @RequestParam double destLng,
            @RequestParam(required = false, defaultValue = "DRIVING") TravelMode travelMode,
            Model model) {

        try {
            // Validate input parameters here if needed

            double distance = mapService.calculateDistance(new Location(originLat, originLng, travelMode), new Location(destLat, destLng, travelMode));
            model.addAttribute("distance", distance);

            // Debugging output
            log.info("Distance calculated: {}", distance);

            // Estimate travel time and add it to the model
            int travelTime = Integer.parseInt(mapService.estimateTravelTime(new Location(originLat, originLng, travelMode), new Location(destLat, destLng, travelMode), travelMode));
            model.addAttribute("travelTime", travelTime);

            return "distanceResult"; // Assuming "distanceResult" is a valid Thymeleaf template
        } catch (Exception e) {
            // Log the exception using a proper logger
            // You can also customize the error message based on the exception type
            model.addAttribute("errorMessage", "An error occurred: " + e.getMessage());

            // Debugging output
            log.error("Error occurred: {}", e.getMessage());

            return "error"; // Assuming "error" is a valid error view
        }
    }

    // Custom exception handler for handling MissingServletRequestParameterException
    @ExceptionHandler(org.springframework.web.bind.MissingServletRequestParameterException.class)
    public ResponseEntity<String> handleMissingParameter(org.springframework.web.bind.MissingServletRequestParameterException ex) {
        String parameterName = ex.getParameterName();
        String errorMessage = "Required parameter '" + parameterName + "' is missing.";
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }
}
