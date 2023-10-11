package uk.sky.jkamp.SpringBoot.services;

public class FlightSearchRequest {

    private String origin;
    private String destination;

    public FlightSearchRequest() {
    }

    public FlightSearchRequest(String origin, String destination) {
        this.origin = origin;
        this.destination = destination;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }
}
