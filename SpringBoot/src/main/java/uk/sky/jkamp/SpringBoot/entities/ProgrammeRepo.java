package uk.sky.jkamp.SpringBoot.entities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.ArrayList;

@Repository
public interface ProgrammeRepo extends JpaRepository<Programme,Long> {


    @Query( value= "SELECT * FROM Programme" , nativeQuery = true)
    List<Programme> findAllProgramme();


    @Query( value= "SELECT * FROM Programme where Title=?1" , nativeQuery = true)
    List<Programme> findProgrammeByTitle();


   @Query( value= "SELECT * FROM Programme where genre=?1" , nativeQuery = true)
    List<Programme> findProgrammeByGenre();

    @Query( value= "SELECT * FROM Programme where genre=?1 and Title=?1" , nativeQuery = true)
    List<Programme> findProgrammeByGenreAndTitle();

        }




