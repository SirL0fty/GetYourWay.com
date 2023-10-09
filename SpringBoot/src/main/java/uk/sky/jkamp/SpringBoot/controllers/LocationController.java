package uk.sky.jkamp.SpringBoot.controllers;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import uk.sky.jkamp.SpringBoot.entities.*;
import uk.sky.jkamp.SpringBoot.services.LocationService;

import java.lang.*;
import java.util.List;
import java.util.ArrayList;
import java.io.*;
import java.lang.System;
@RestController
public class LocationController {

    private LocationService locationsservice;
    private LocationRepo locationrepo;

    public LocationController(LocationService locationsservice) {
        this.locationsservice = locationsservice;
    }

    private List<Location> locations= new ArrayList<>();

    @PostMapping("/createLocation")
    public Location addLocation(@RequestBody @Valid Location location)
    {
        return this.locationsservice.createLocation(location);

    }

    @GetMapping("/getAllLocations")
    public List<Location> getAllLocation() {

        return this.locationrepo.findAllLocation();

    }



}








