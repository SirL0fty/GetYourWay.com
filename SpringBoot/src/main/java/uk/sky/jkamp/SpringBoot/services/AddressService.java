package uk.sky.jkamp.SpringBoot.services;
import jakarta.validation.Valid;
import org.springframework.data.jpa.repository.Query;
import uk.sky.jkamp.SpringBoot.entities.Address;
import uk.sky.jkamp.SpringBoot.entities.AddressRepo;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Service;
import uk.sky.jkamp.SpringBoot.entities.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
 @Service
public class AddressService {
     private AddressRepo addressRepo;
     private List<Address> addresses=new ArrayList<>();

     public  List<Address> findAllAddresses()
     {return this.addressRepo.findAllAddress();
     }

     public Address createAddress(@RequestBody @Valid Address address)
     {

         return this.addressRepo.save(address);

     }




 }
