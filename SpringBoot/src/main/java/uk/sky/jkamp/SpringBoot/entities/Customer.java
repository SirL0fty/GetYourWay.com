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
public class Customer {
    // init the id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerID;

    // get and set for id


    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }


    //init the name
    @Size(min = 0, max = 28)
    @NotNull
    private String name;

    @Size(min = 0, max = 28)
    @NotNull
    private String email;

    @Size(min = 0, max = 28)
    @NotNull
    //private Address address;

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








