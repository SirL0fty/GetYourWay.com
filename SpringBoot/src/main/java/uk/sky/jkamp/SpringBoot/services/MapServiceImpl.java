package uk.sky.jkamp.SpringBoot.services;
import com.google.maps.DirectionsApi;
import com.google.maps.DirectionsApiRequest;
import com.google.maps.GeoApiContext;
import com.google.maps.model.DirectionsLeg;
import com.google.maps.model.DirectionsResult;

import com.google.maps.model.TravelMode;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import uk.sky.jkamp.SpringBoot.Location;

@Service
public class MapServiceImpl implements MapService {

    @Value("${google.maps.api.key}")
    private String googleMapsApiKey;

    @Override
    public double calculateDistance(Location origin, Location destination) { // Implement the calculateDistance method
        try {
            GeoApiContext context = new GeoApiContext.Builder().apiKey(googleMapsApiKey).build(); // Create a GeoApiContext object

            DirectionsApiRequest request = DirectionsApi.newRequest(context) // Create a DirectionsApiRequest object
                    .origin(new com.google.maps.model.LatLng(origin.getLatitude(), origin.getLongitude())) // Set the origin
                    .destination(new com.google.maps.model.LatLng(destination.getLatitude(), destination.getLongitude())) // Set the destination
                    .mode(TravelMode.DRIVING); // Set the travel mode to DRIVING

            DirectionsResult routes = request.await(); // Call the Directions API and wait for the result

            if (routes != null && routes.routes.length > 0) { // Check that at least one route was found
                DirectionsLeg leg = routes.routes[0].legs[0]; // Get the first leg of the first route
                double distanceInMeters = leg.distance.inMeters; // Get the distance in meters

                // Convert meters to miles
                return distanceInMeters * 0.000621371;
            } else {
                return -1; // Handle no routes found
            }
        } catch (InterruptedException e) {
            // Restore interrupted status
            Thread.currentThread().interrupt();
            return -1; // Handle interruption
        } catch (Exception e) {
            e.printStackTrace();
            return -1; // Handle other exceptions
        }
    }

    private void validateInput(Location origin, Location destination) {
        if (origin == null || destination == null) {
            throw new IllegalArgumentException("Both origin and destination locations must be provided.");
        }

        if (origin.getLatitude() < -90 || origin.getLatitude() > 90) {
            throw new IllegalArgumentException("Origin latitude must be between -90 and 90 degrees.");
        }

        if (origin.getLongitude() < -180 || origin.getLongitude() > 180) {
            throw new IllegalArgumentException("Origin longitude must be between -180 and 180 degrees.");
        }

        if (destination.getLatitude() < -90 || destination.getLatitude() > 90) {
            throw new IllegalArgumentException("Destination latitude must be between -90 and 90 degrees.");
        }

        if (destination.getLongitude() < -180 || destination.getLongitude() > 180) {
            throw new IllegalArgumentException("Destination longitude must be between -180 and 180 degrees.");
        }
    }

    @Override
    public String estimateTravelTime(Location origin, Location destination, TravelMode travelMode) {
        try {
            GeoApiContext context = new GeoApiContext.Builder().apiKey(googleMapsApiKey).build();

            DirectionsApiRequest request = DirectionsApi.newRequest(context)
                    .origin(new com.google.maps.model.LatLng(origin.getLatitude(), origin.getLongitude()))
                    .destination(new com.google.maps.model.LatLng(destination.getLatitude(), destination.getLongitude()))
                    .mode(travelMode);

            DirectionsResult routes = request.await();

            if (routes != null && routes.routes.length > 0) {
                DirectionsLeg leg = routes.routes[0].legs[0];
                return String.valueOf(Math.round(leg.duration.inSeconds / 3600.0));
            } else {
                return "-1";
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            // Log the exception instead of printing the stack trace
            // logger.error("Interrupted exception occurred", e);
            return "-1";
        } catch (Exception e) {
            // Log the exception instead of printing the stack trace
            // logger.error("Exception occurred", e);
            return "-1";
        }
    }
}
