package uk.sky.jkamp.SpringBoot.entities;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.persistence.Entity;

@Entity
public class Location{

//    - name: String
//- latitude: Double
//- longitude: Double


    public Location() {


    }

    public Location(double latitude, double longitude) {

        this.latitude = latitude;
        this.longitude = longitude;
    }



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @NotNull
    private double latitude;

    @NotNull
    private double longitude;

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
