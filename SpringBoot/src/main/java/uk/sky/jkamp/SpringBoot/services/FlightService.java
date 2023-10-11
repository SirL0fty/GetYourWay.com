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

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import uk.sky.jkamp.SpringBoot.services.DTO.FlightDTO;

@Service
@Slf4j
public class FlightService {

    private static final Logger logger = LoggerFactory.getLogger(FlightService.class);

    @Value("${amadeus.access.token}")
    private String accessToken;

    @Value("${amadeus.baseUrl}")
    private String baseUrl;

    private final RestTemplate restTemplate;

    public FlightService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<FlightDTO> getFlights(String origin, String destination, LocalDate departureDate, int adults, int children) {
        String url = baseUrl + "/v2/shopping/flight-offers";

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("originLocationCode", origin)
                .queryParam("destinationLocationCode", destination)
                .queryParam("departureDate", departureDate)
                .queryParam("adults", adults)
                .queryParam("children", children);

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + accessToken);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        try {
            ResponseEntity<FlightResponse> responseEntity = restTemplate.exchange( // Call the Amadeus API
                    builder.toUriString(), // Specify the URL
                    HttpMethod.GET, // Specify the HTTP method
                    new HttpEntity<>(headers),
                    FlightResponse.class
            );

            if (responseEntity.getStatusCode().is4xxClientError() || responseEntity.getStatusCode().is5xxServerError()) {
                if (responseEntity.getStatusCode().equals(HttpStatus.NOT_FOUND)) {
                    throw new FlightNotFoundException("Flight not found");
                } else {
                    throw new FlightServiceException("Flight service error");
                }
            }

            FlightResponse flightResponse = responseEntity.getBody();
            if (flightResponse != null) {
                return flightResponse.getData();
            } else {
                return new ArrayList<>();
            }
        } catch (WebClientResponseException e) {
            // Log the error
            logger.error("Error calling Amadeus API: {}", e.getMessage());

            // Throw a more specific exception
            throw new FlightServiceException("Flight service error", e);
        } catch (Exception e) {
            // Log the error
            logger.error("Unexpected error calling Amadeus API: {}", e.getMessage());

            // Throw a general exception
            throw new FlightServiceException("Flight service error", e);
        }
    }
}
