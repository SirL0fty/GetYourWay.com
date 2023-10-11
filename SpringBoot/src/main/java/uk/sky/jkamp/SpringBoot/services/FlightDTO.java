package uk.sky.jkamp.SpringBoot.services;

import lombok.Getter;
import java.time.LocalDateTime;
import java.util.List;

@Getter
public class FlightDTO {
    private String airline;
    private String flightNumber;
    private String origin;
    private String destination;
    private LocalDateTime departureDateTime;
    private LocalDateTime arrivalDateTime;
    private Price price; // Updated to use the Price class


    private List<Itinerary> itineraries;


    public FlightDTO(String airline, String flightNumber, String origin, String destination,
                     LocalDateTime departureDateTime, LocalDateTime arrivalDateTime, Price price) {
        this.airline = airline;
        this.flightNumber = flightNumber;
        this.origin = origin;
        this.destination = destination;
        this.departureDateTime = departureDateTime;
        this.arrivalDateTime = arrivalDateTime;
        this.price = price;
    }

    public List<Itinerary> getItineraries() {
        return itineraries;
    }

    public void setItineraries(List<Itinerary> itineraries) {
        this.itineraries = itineraries;
    }

    public FlightDTO() {
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setDepartureDateTime(LocalDateTime departureDateTime) {
        this.departureDateTime = departureDateTime;
    }

    public void setArrivalDateTime(LocalDateTime arrivalDateTime) {
        this.arrivalDateTime = arrivalDateTime;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    // Nested Price class to model the "price" field in the JSON response
    @Getter
    public static class Price {
        private String currency;
        private String total;
        private String base;

        // Getters and setters for Price fields

        public void setCurrency(String currency) {
            this.currency = currency;
        }

        public void setTotal(String total) {
            this.total = total;
        }

        public void setBase(String base) {
            this.base = base;
        }
    }
}
