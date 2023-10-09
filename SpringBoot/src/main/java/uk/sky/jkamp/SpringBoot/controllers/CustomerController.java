package uk.sky.jkamp.SpringBoot.controllers;
import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import uk.sky.jkamp.SpringBoot.entities.Customer;
import uk.sky.jkamp.SpringBoot.entities.CustomerRepo;
import uk.sky.jkamp.SpringBoot.entities.Programme;
import uk.sky.jkamp.SpringBoot.services.CustomerService;
import java.lang.*;
import java.util.List;
import java.util.ArrayList;
import java.io.*;
import java.lang.System;
@RestController
public class CustomerController {

    private CustomerService customerservice;
    private CustomerRepo customerrepo;
    public CustomerController(CustomerService customerservice) {
       super();
        this.customerservice = customerservice;
    }

    private List<Customer> customers=new ArrayList<>();

    @PostMapping("/createCustomer")
    public Customer addCustomer(@RequestBody @Valid Customer customer)
    {
        return this.customerservice.createCustomer(customer);

    }

    @GetMapping("/getAllCustomers")
    public List<Customer> findAllCustomer() {

       return this.customerrepo.findAllCustomer();

    }



}
