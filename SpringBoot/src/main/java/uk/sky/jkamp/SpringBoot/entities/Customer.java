package uk.sky.jkamp.SpringBoot.entities;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails;

import java.util.ArrayList;


@Entity
public class Customer  {

    public Customer() {

    }
    public Customer( String name, String email, boolean hasEnabled2FA) {

        this.name = name;
        this.email = email;
        this.hasEnabled2FA = hasEnabled2FA;
    }

    public Customer(String street, String city, String county,
                    String postCode, String name, String email, boolean hasEnabled2FA) {
        super();
        this.name = name;
        this.email = email;
        this.hasEnabled2FA = hasEnabled2FA;
    }

    // init the id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // get and set for id


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    //init the name
    @Size(min = 0, max = 28)
    @NotNull
    private String name;

    @Size(min = 0, max = 28)
    @NotNull
    private String email;


    private boolean hasEnabled2FA;

    //private List<Journey> journeys = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



    public boolean isHasEnabled2FA() {
        return hasEnabled2FA;
    }

    public void setHasEnabled2FA(boolean hasEnabled2FA) {
        this.hasEnabled2FA = hasEnabled2FA;
    }

}








