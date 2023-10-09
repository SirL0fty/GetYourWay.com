package uk.sky.jkamp.SpringBoot.entities;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.context.annotation.Bean;


@Entity
public class Programme {

    public Programme() {
        this("American Horror Story","Horror");
    }

    public Programme(String title, String genre) {
        Title = title;
        Genre = genre;
    }

    public Programme(double latitude, double longitude, String title, String genre) {

        Title = title;
        Genre = genre;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long programmeID;

    @Size(min=0,max=30)
    @NotNull
    private String Title;

    @Size(min=0,max=30)
    @NotNull
    private String Genre;


    @ManyToOne
    private Location location;

    //gets and sets :

    public long getProgrammeID() {
        return programmeID;
    }

    public void setProgrammeID(long programmeID) {
        this.programmeID = programmeID;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getGenre() {
        return Genre;
    }

    public void setGenre(String genre) {
        Genre = genre;
    }


//    - programmeID: int
//- name: String
//- genre: String
//- location: Location





}
