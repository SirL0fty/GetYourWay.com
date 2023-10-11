package uk.sky.jkamp.SpringBoot.services;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Segment {

    private Departure departure;
    private Arrival arrival;

    public Departure getDeparture() {
        return departure;
    }

    public void setDeparture(Departure departure) {
        this.departure = departure;
    }

    public Arrival getArrival() {
        return arrival;
    }

    public void setArrival(Arrival arrival) {
        this.arrival = arrival;
    }
}
