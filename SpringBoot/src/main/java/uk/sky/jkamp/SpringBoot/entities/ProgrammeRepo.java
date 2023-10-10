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


    @Query( value= "SELECT * FROM Programme where title=?1" , nativeQuery = true)
    List<Programme> findProgrammeByTitle(String title);


   @Query( value= "SELECT * FROM Programme where genre=?1" , nativeQuery = true)
    List<Programme> findProgrammeByGenre(String genre);

    @Query( value= "SELECT * FROM Programme where genre=?2 and title=?1" , nativeQuery = true)
    List<Programme> findProgrammeByGenreAndTitle(String title,String genre);

        }




