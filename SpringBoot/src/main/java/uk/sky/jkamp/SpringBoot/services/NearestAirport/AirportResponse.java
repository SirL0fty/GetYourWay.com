package uk.sky.jkamp.SpringBoot.services.NearestAirport;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import uk.sky.jkamp.SpringBoot.services.DTO.AirportDTO;

import java.util.List;

public class AirportResponse {
    @JsonProperty("data")
    private List<AirportDTO> data;

    public List<AirportDTO> getData() {
        return data;
    }

    public void setData(List<AirportDTO> data) {
        this.data = data;
    }
}
