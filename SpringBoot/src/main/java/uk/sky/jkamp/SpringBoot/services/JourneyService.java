package uk.sky.jkamp.SpringBoot.services;

import jakarta.validation.Valid;
import org.springframework.data.jpa.repository.Query;
import uk.sky.jkamp.SpringBoot.entities.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class JourneyService {


    private JourneyRepo journeyRepo;
    private List<Journey> journeys = new ArrayList<>();

    public List<Journey> findAllJourneys() {
        return this.journeyRepo.findAllJourney();
    }

    public Journey createJourney(@RequestBody @Valid Journey journey)
    {

        return this.journeyRepo.save(journey);

    }
}
