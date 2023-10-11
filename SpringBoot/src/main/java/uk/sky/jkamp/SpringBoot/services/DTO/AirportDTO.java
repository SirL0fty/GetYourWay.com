package uk.sky.jkamp.SpringBoot.services.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;

import java.sql.Time;

@Data
public class AirportDTO {

    private String type;

    private String subType;

    private String name;

    private String detailedName;

    private String timeZoneOffset;

    private String iataCode;

    private GeoCode geoCode;

    private Distance distance;

    private Address address;
    @Data
    public static class Address {
        private String cityName;
        private String cityCode;
        private String countryName;
        private String countryCode;
        private String regionCode;
    }

    @Data
    public static class GeoCode {
        private String latitude;
        private String longitude;

    }
    @Data
    public static class Distance {
        private float value;
        private String unit;

    }
}
