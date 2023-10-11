package uk.sky.jkamp.SpringBoot.services.DTO;

import lombok.Getter;
import uk.sky.jkamp.SpringBoot.services.DTO.Itinerary;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class FlightDTO {

    @Getter
    private String type;
    @Getter
    private String source;
    @Getter
    private String id;
    private Price price; // Updated to use the Price class


    @Getter
    private List<Itinerary> itineraries;


    public FlightDTO(String id, String source, String airline, String flightNumber, String origin, String destination,
                     LocalDateTime departureDateTime, LocalDateTime arrivalDateTime, Price price) {
        this.id = id;
        this.source = source;
        this.price = price;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public void setItineraries(List<Itinerary> itineraries) {
        this.itineraries = itineraries;
    }

    public FlightDTO() {
    }

    public void setId(String id) {
        this.id = id;
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
