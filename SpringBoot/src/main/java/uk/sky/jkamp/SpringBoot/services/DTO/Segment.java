package uk.sky.jkamp.SpringBoot.services.DTO;

import uk.sky.jkamp.SpringBoot.services.DTO.Arrival;
import uk.sky.jkamp.SpringBoot.services.DTO.Departure;

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
