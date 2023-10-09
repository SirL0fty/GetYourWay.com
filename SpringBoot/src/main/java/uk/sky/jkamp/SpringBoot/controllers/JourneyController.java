package uk.sky.jkamp.SpringBoot.controllers;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import uk.sky.jkamp.SpringBoot.entities.*;
import uk.sky.jkamp.SpringBoot.services.JourneyService;
import uk.sky.jkamp.SpringBoot.services.LocationService;

import java.lang.*;
import java.util.List;
import java.util.ArrayList;
import java.io.*;
import java.lang.System;
@RestController
public class JourneyController {

    private JourneyService journeysservice;
    private JourneyRepo journeyrepo;

    public JourneyController(JourneyService journeysservice) {
        this.journeysservice = journeysservice;
    }

    private List<Journey> journeys= new ArrayList<>();

    @PostMapping("/createJourney")
    public Journey addJourney(@RequestBody @Valid Journey journey)
    {
        return this.journeysservice.createJourney(journey);

    }

    @GetMapping("/getAllJourneys")
    public List<Journey> getAllLJourney() {

        return this.journeyrepo.findAllJourney();

    }

}
