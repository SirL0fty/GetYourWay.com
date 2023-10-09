package uk.sky.jkamp.SpringBoot.controllers;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import uk.sky.jkamp.SpringBoot.entities.*;
import uk.sky.jkamp.SpringBoot.services.AddressService;
import uk.sky.jkamp.SpringBoot.services.CustomerService;
import java.lang.*;
import java.util.List;
import java.util.ArrayList;
import java.io.*;
import java.lang.System;
@RestController
public class AddressController {
    private AddressService addressesservice;
    private AddressRepo addressrepo;

    public AddressController(AddressService addressesservice) {
        super();
        this.addressesservice = addressesservice;
    }

    private List<Address> addresses= new ArrayList<>();

    @PostMapping("/createAddress")
    public Address addAddress(@RequestBody @Valid Address address)
    {
        return this.addressesservice.createAddress(address);

    }

    @GetMapping("/getAllAddresses")
    public List<Address> getAllAddress() {

        return this.addressrepo.findAllAddress();

    }



}


