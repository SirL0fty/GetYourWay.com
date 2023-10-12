package uk.sky.jkamp.SpringBoot.services;

import com.google.maps.model.TravelMode;
import uk.sky.jkamp.SpringBoot.Location;

public interface MapService {

    double calculateDistance(Location origin, Location destination); // Calculates the distance between two locations.

    String estimateTravelTime(Location origin, Location destination, TravelMode travelMode); // Calculates the estimated travel time between two locations.
}