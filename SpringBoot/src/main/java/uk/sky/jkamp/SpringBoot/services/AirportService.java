package uk.sky.jkamp.SpringBoot.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import org.springframework.web.util.UriComponentsBuilder;
import uk.sky.jkamp.SpringBoot.exceptions.FlightNotFoundException;
import uk.sky.jkamp.SpringBoot.exceptions.FlightServiceException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import uk.sky.jkamp.SpringBoot.services.NearestAirport.AirportResponse;

@Service
@Slf4j
public class AirportService {

    private static final Logger logger = LoggerFactory.getLogger(AirportService.class);

    @Value("${amadeus.access.token}")
    private String accessToken;

    @Value("${amadeus.baseUrl}")
    private String baseUrl;

    private final RestTemplate restTemplate;

    public AirportService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<AirportResponse> getNearestRelevantAirports(String latitude, String longitude, String radius) {
        String url = baseUrl + "/v1/reference-data/locations/airports";

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("latitude", latitude)
                .queryParam("longitude", longitude)
                .queryParam("radius", radius);

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + accessToken);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        try {
            ResponseEntity<String> airportEntity = restTemplate.exchange( // Call the Amadeus API
                    builder.toUriString(), // Specify the URL
                    HttpMethod.GET, // Specify the HTTP method
                    new HttpEntity<>(headers),
                    String.class
            );
            System.out.println(airportEntity.getBody());

            ResponseEntity<AirportResponse> responseEntity = restTemplate.exchange( // Call the Amadeus API
                    builder.toUriString(), // Specify the URL
                    HttpMethod.GET, // Specify the HTTP method
                    new HttpEntity<>(headers),
                    AirportResponse.class
            );

            if (responseEntity.getStatusCode().is4xxClientError() || responseEntity.getStatusCode().is5xxServerError()) {
                if (responseEntity.getStatusCode().equals(HttpStatus.NOT_FOUND)) {
                    throw new FlightNotFoundException("Airport not found");
                } else {
                    throw new FlightServiceException("Airport service error");
                }
            }

            AirportResponse airportRespons = responseEntity.getBody();
            if (airportRespons != null) {
                return List.of(airportRespons);
            } else {
                return new ArrayList<>();
            }
        } catch (WebClientResponseException e) {
            // Log the error
            logger.error("Error calling Amadeus API: {}", e.getMessage());

            // Throw a more specific exception
            throw new FlightServiceException("Airport service error", e);
        } catch (Exception e) {
            // Log the error
            logger.error("Unexpected error calling Amadeus API: {}", e.getMessage());

            // Throw a general exception
            throw new FlightServiceException("Airport service error", e);
        }
    }
}
