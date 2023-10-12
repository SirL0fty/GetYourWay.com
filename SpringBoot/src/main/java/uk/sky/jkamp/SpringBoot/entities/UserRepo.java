package uk.sky.jkamp.SpringBoot.entities;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import uk.sky.jkamp.SpringBoot.entities.User;


public interface UserRepo extends JpaRepository<User, Integer> {

    Optional<User> findByUsername(String userName);

}