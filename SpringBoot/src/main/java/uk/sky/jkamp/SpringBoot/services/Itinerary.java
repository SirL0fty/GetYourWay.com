package uk.sky.jkamp.SpringBoot.services;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Itinerary {

   private List<Segment> segments;

   private String duration;

    @JsonCreator
    public Itinerary(@JsonProperty("segments") List<Segment> segments, String duration) {
        this.segments = segments;
        this.duration = duration;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public List<Segment> getSegments() {
        return segments;
    }

//    public void setSegments(List<Segment> segments) {
//        this.segments = segments;
//    }
}
