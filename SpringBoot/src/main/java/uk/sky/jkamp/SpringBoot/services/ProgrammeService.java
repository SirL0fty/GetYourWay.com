package uk.sky.jkamp.SpringBoot.services;
import jakarta.validation.Valid;
import org.springframework.data.jpa.repository.Query;
import uk.sky.jkamp.SpringBoot.entities.Programme;
import uk.sky.jkamp.SpringBoot.entities.ProgrammeRepo;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProgrammeService {

//    - programmeID: int
//- name: String
//- genre: String
//- location: Location

    private ProgrammeRepo programmeRepo;
    private List<Programme> programmes=new ArrayList<>();

    public ProgrammeService(ProgrammeRepo programmeRepo) {
        super();
        this.programmeRepo = programmeRepo;

    }

    public Programme createProgramme(@RequestBody @Valid Programme programme)
    {

       return this.programmeRepo.save(programme);

    }

    public List<Programme> findAllProgrammes()
    {
        return this.programmeRepo.findAllProgramme();
    }


    public List<Programme> findAllProgrammeByTitle()
    {
        return this.programmeRepo.findProgrammeByTitle();
    }

    public List<Programme> findAllProgrammeByGenre()
    {
        return this.programmeRepo.findProgrammeByGenre();
    }
    public List<Programme> findAllProgrammeByGenreAndTitle()
    {
        return this.programmeRepo.findProgrammeByGenreAndTitle();
    }



}
