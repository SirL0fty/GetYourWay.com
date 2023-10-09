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
public class Address {


    public Address() {
        this("eg: Sesame street","eg: London"," eg: Greater London","eg :W1T");
    }

    public Address(String street, String city, String county, String postCode) {
        Street = street;
        this.city = city;
        this.county = county;
        this.postCode = postCode;
    }

    public Address(int addressID, String street, String city, String county, String postCode) {
        this.addressID = addressID;
        Street = street;
        this.city = city;
        this.county = county;
        this.postCode = postCode;
    }



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int addressID;

    @NotNull
    @Size(min=0,max=28)
    private String Street;

    @NotNull
    @Size(min=0,max=20)
    private String city;


    @Size(min=0,max=20)
    private String county;

    @NotNull
    @Size(min=0,max=20)
    private String postCode;

    //gets and sets :

    public void setStreet(String street) {
        Street = street;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }





}
