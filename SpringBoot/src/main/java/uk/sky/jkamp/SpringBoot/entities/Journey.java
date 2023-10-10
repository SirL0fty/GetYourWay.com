package uk.sky.jkamp.SpringBoot.entities;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class Journey {

    public Journey() {
    }

    public Journey(String title, String transportationMode, String departureDate, String departureTime, String arrivalDate) {
        this.title = title;
        this.transportationMode = transportationMode;
        this.departureDate = departureDate;
        this.departureTime = departureTime;
        this.arrivalDate = arrivalDate;
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
    @Size(min=0,max=28)
    private String title;

    @NotNull
    @Size(min=0,max=28)
    private String transportationMode;


    @Size(min=0,max=28)
    private String departureDate;


    @Size(min=0,max=28)
    private String departureTime;


    @Size(min=0,max=28)
    private String arrivalDate;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTransportationMode() {
        return transportationMode;
    }

    public void setTransportationMode(String transportationMode) {
        this.transportationMode = transportationMode;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(String arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    //   .. - title: String
//- from loc class arrivalLocation: Location
//- ..departureTime: LocalTime
//- ..transportationMode: String
//- ..departureDate: Date
//- ..arrivalDate: Date
//-.. programme: Programme

}
