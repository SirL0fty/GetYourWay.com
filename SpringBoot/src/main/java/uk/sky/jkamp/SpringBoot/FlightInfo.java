package uk.sky.jkamp.SpringBoot;

import java.time.LocalDateTime;

public class FlightInfo {
    private String flightNumber;
    private String airline;
    private LocalDateTime departureDateTime;
    private LocalDateTime arrivalDateTime;
    private String originAirport;
    private String destinationAirport;

    // Constructors, getters, and setters

    public FlightInfo() {
    }

    public FlightInfo(String flightNumber, String airline, LocalDateTime departureDateTime, LocalDateTime arrivalDateTime, String originAirport, String destinationAirport) {
        this.flightNumber = flightNumber;
        this.airline = airline;
        this.departureDateTime = departureDateTime;
        this.arrivalDateTime = arrivalDateTime;
        this.originAirport = originAirport;
        this.destinationAirport = destinationAirport;
    }

    // Getters and setters for each field

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public LocalDateTime getDepartureDateTime() {
        return departureDateTime;
    }

    public void setDepartureDateTime(LocalDateTime departureDateTime) {
        this.departureDateTime = departureDateTime;
    }

    public LocalDateTime getArrivalDateTime() {
        return arrivalDateTime;
    }

    public void setArrivalDateTime(LocalDateTime arrivalDateTime) {
        this.arrivalDateTime = arrivalDateTime;
    }

    public String getOriginAirport() {
        return originAirport;
    }

    public void setOriginAirport(String originAirport) {
        this.originAirport = originAirport;
    }

    public String getDestinationAirport() {
        return destinationAirport;
    }

    public void setDestinationAirport(String destinationAirport) {
        this.destinationAirport = destinationAirport;
    }
}
