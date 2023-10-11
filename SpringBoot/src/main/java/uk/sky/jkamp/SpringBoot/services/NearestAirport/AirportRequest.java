package uk.sky.jkamp.SpringBoot.services.NearestAirport;

public class AirportRequest {

    private String latitude;
    private String longitude;
    private String radius;

    public AirportRequest() {
    }

    public AirportRequest(String latitude, String longitude, String radius) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.radius = radius;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getRadius() {
        return radius;
    }

    public void setRadius(String radius) {
        this.radius = radius;
    }
}
