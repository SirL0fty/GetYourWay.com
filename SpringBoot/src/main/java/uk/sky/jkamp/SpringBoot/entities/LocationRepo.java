package uk.sky.jkamp.SpringBoot.entities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface LocationRepo extends JpaRepository<Location,Long>{

    @Query( value= "SELECT * FROM Location" , nativeQuery = true)
    List<Location> findAllLocation();
}
