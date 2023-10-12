package uk.sky.jkamp.SpringBoot.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uk.sky.jkamp.SpringBoot.entities.User;
import uk.sky.jkamp.SpringBoot.entities.UserCredentials;
import uk.sky.jkamp.SpringBoot.entities.UserRepo;

import java.util.Optional;

@RestController
@RequestMapping("/authenticcontrol")
public class AuthController {

    // Simulated user repository (replace with your actual user repository)
    private UserRepo userRepo;
    public AuthController(UserRepo userRepo) {
        this.userRepo= userRepo;
    }
   private User u;

    @PostMapping("/login")
    public ResponseEntity<String> authenticateUser(@RequestBody UserCredentials userCredentials) {
        // Retrieve user from the repository using the provided email
        Optional<User> user = userRepo.findByEmail(userCredentials.getEmail());

        if (!(user == null && !u.getPassword().equals(userCredentials.getPasswordc()))) {
            // Authentication successful
            return ResponseEntity.ok("Authentication successful");
        } else {
            // Authentication failed
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Authentication failed");
        }
    }
}






















