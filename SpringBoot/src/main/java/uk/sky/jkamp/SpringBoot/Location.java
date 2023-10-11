package uk.sky.jkamp.SpringBoot;

import com.google.maps.model.TravelMode;
import lombok.Getter;

@Getter
public class Location {
    private double latitude;
    private double longitude;
    private TravelMode travelMode;

    public Location(double latitude, double longitude, TravelMode travelMode) {
        if (isValidLatitude(latitude) && isValidLongitude(longitude)) {
            this.latitude = latitude;
            this.longitude = longitude;
            this.travelMode = travelMode;
        } else {
            throw new IllegalArgumentException("Invalid latitude or longitude values");
        }
    }

    public void setLatitude(double latitude) {
        if (isValidLatitude(latitude)) {
            this.latitude = latitude;
        } else {
            throw new IllegalArgumentException("Invalid latitude value");
        }
    }

    public void setLongitude(double longitude) {
        if (isValidLongitude(longitude)) {
            this.longitude = longitude;
        } else {
            throw new IllegalArgumentException("Invalid longitude value");
        }
    }

    public void setTravelMode(TravelMode travelMode) {
        this.travelMode = travelMode;
    }

    private boolean isValidLatitude(double latitude) {
        return latitude >= -90.0 && latitude <= 90.0;
    }

    private boolean isValidLongitude(double longitude) {
        return longitude >= -180.0 && longitude <= 180.0;
    }

    // Add a toString method to return a string representation
    @Override
    public String toString() {
        return latitude + "," + longitude;
    }

    public static Location fromString(String locationString) { // Add a static fromString method to create a Location object from a string
        String[] parts = locationString.split(","); // Split the string on the comma character
        if (parts.length == 2) { // Check that there are two parts
            try { // Try to parse the latitude and longitude values
                double latitude = Double.parseDouble(parts[0]); // Parse the latitude value
                double longitude = Double.parseDouble(parts[1]); // Parse the longitude value
                return new Location(latitude, longitude, TravelMode.DRIVING); // Return a new Location object
            } catch (NumberFormatException e) { // Catch any NumberFormatExceptions
                throw new IllegalArgumentException("Invalid latitude or longitude format"); // Throw an IllegalArgumentException
            }
        } else { // If there are not two parts
            throw new IllegalArgumentException("Invalid latitude or longitude format"); // Throw an IllegalArgumentException
        }
    }
}
