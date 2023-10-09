package uk.sky.jkamp.SpringBoot.entities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface JourneyRepo extends JpaRepository<Journey,Long>{

    @Query( value= "SELECT * FROM Journey" , nativeQuery = true)
    List<Journey> findAllJourney();

}
