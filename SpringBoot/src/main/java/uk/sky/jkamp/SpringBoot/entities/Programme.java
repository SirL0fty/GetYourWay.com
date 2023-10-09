package uk.sky.jkamp.SpringBoot.entities;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Programme extends Location{

    public Programme() {
        this("American Horror Story","Horror");
    }

    public Programme(String title, String genre) {
        Title = title;
        Genre = genre;
    }

    public Programme(double latitude, double longitude, String title, String genre) {
        super(latitude, longitude);
        Title = title;
        Genre = genre;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int programmeID;

    @Size(min=0,max=30)
    @NotNull
    private String Title;

    @Size(min=0,max=30)
    @NotNull
    private String Genre;


    //private Location location;

    //gets and sets :

    public int getProgrammeID() {
        return programmeID;
    }

    public void setProgrammeID(int programmeID) {
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
