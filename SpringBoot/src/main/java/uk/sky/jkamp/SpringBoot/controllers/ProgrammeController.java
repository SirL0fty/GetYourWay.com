package uk.sky.jkamp.SpringBoot.controllers;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import uk.sky.jkamp.SpringBoot.entities.*;
import uk.sky.jkamp.SpringBoot.services.LocationService;
import uk.sky.jkamp.SpringBoot.services.ProgrammeService;
import uk.sky.jkamp.SpringBoot.entities.ProgrammeRepo;
import java.lang.*;
import java.util.List;
import java.util.ArrayList;
import java.io.*;
import java.lang.System;
@RestController
@CrossOrigin
public class ProgrammeController {

    private ProgrammeService programmesservice;
    private ProgrammeRepo programmerepo;

    public ProgrammeController(ProgrammeService programmesservice) {
        this.programmesservice = programmesservice;
    }

    private List<Programme> programmes= new ArrayList<>();

    @PostMapping("/createProgramme")
    public Programme addProgramme(@RequestBody @Valid Programme programme)
    {
       return this.programmesservice.createProgramme(programme);
    }

    @GetMapping("/getAllProgramme")
    public List<Programme> getAllProgramme() {

        return this.programmesservice.findAllProgrammes();

    }
    @GetMapping("/getAllProgrammebyTitle")
    public List<Programme> getAllProgrammeByTitle(@RequestParam(value="title") String title)
    {

        return this.programmesservice.findAllProgrammeByTitle(title);

    }

    @GetMapping("/getAllProgrammebyGenre")
    public List<Programme> getAllProgrammeByGenre(@RequestParam(value="genre") String genre) {

        return this.programmesservice.findAllProgrammeByGenre(genre);

    }

//    findAllProgrammeByGenreAndTitle()

    @GetMapping("/getAllProgrammebyGenreandTitle")
    public List<Programme> getAllProgrammeByGenreAndTitle(@RequestParam(value="title") String title,@RequestParam(value="genre") String genre) {

        return this.programmesservice.findAllProgrammeByGenreAndTitle(title,genre);

    }




}
