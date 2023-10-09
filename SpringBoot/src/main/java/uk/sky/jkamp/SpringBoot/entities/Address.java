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





    public Address(int id, String street, String city, String county, String postCode) {
        this.id = id;
        this.street = street;
        this.city = city;
        this.county = county;
        this.postCode = postCode;
    }
    public Address() {
//        this("eg: Sesame street","eg: London"," eg: Greater London","eg :W1T");
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Size(min=0,max=28)
    private String street;

    @NotNull
    @Size(min=0,max=20)
    private String city;


    @Size(min=0,max=20)
    private String county;

    @NotNull
    @Size(min=0,max=20)
    private String postCode;

    //gets and sets :


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }
}
