package uk.sky.jkamp.SpringBoot.entities;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uk.sky.jkamp.SpringBoot.entities.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

    Optional<User> findByUsername(String userName);
    Optional<User> findByEmail(String email);
    User findByPassword(String password);
}