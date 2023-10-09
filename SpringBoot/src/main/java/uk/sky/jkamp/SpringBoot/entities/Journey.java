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

    public Journey(String title, String transportationMode,
                   LocalDate departureDate, LocalTime departureTime, LocalDate arrivalDate) {
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

    @NotNull
    @Size(min=0,max=28)
    private LocalDate departureDate;

    @NotNull
    @Size(min=0,max=28)
    private LocalTime departureTime;

    @NotNull
    private LocalDate arrivalDate;

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

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalTime departureTime) {
        this.departureTime = departureTime;
    }

    public LocalDate getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(LocalDate arrivalDate) {
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
