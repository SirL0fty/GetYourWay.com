package uk.sky.jkamp.SpringBoot.services;
import jakarta.validation.Valid;
import org.springframework.data.jpa.repository.Query;
import uk.sky.jkamp.SpringBoot.entities.Customer;
import uk.sky.jkamp.SpringBoot.entities.CustomerRepo;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Service;
import uk.sky.jkamp.SpringBoot.entities.Programme;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class CustomerService {

    public CustomerService(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    private CustomerRepo customerRepo;
    private List<Customer> customers=new ArrayList<>();

    public  List<Customer> findAllCustomers(){
        return this.customerRepo.findAllCustomers();
    }

    public Customer createCustomer(@RequestBody @Valid Customer customer)
    {

        return this.customerRepo.save(customer);

    }

}
