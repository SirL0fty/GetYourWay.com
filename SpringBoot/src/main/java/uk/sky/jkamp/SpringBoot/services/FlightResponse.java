package uk.sky.jkamp.SpringBoot.services;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import uk.sky.jkamp.SpringBoot.services.DTO.FlightDTO;

import java.util.List;

@Getter
public class FlightResponse {

    private List<FlightDTO> data;

    @JsonCreator
    public FlightResponse(@JsonProperty("data") List<FlightDTO> data) {
        this.data = data;
    }

    public List<FlightDTO> getData() {
        return data;
    }

    public void setData(List<FlightDTO> data) {
        this.data = data;
    }
}
