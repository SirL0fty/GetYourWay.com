package uk.sky.jkamp.SpringBoot.services;



import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import uk.sky.jkamp.SpringBoot.entities.User;
import uk.sky.jkamp.SpringBoot.entities.UserRepo;


@Service
public class UserService implements UserDetailsService {

    public UserRepo repo;

    private BCryptPasswordEncoder encoder;

    public UserService(UserRepo userRepo, BCryptPasswordEncoder encoder) {
        super();
        this.repo = userRepo;
        this.encoder = encoder;
    }

    public String registerUser(User user) {

        // encode password into hash in db

        user.setPassword(this.encoder.encode(user.getPassword()));
        User saved = this.repo.save(user);
        return saved.getUsername();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.repo.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("No user exists with name: " + username));

    }

}