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
public class LocationService {


    private LocationRepo locationRepo;
    private List<Location> locations = new ArrayList<>();

    public LocationService(LocationRepo locationRepo) {
        this.locationRepo = locationRepo;
    }

    public List<Location> findAllLocations() {
        return this.locationRepo.findAllLocations();
    }

    public Location createLocation(@RequestBody @Valid Location location)
    {

        return this.locationRepo.save(location);

    }


}
