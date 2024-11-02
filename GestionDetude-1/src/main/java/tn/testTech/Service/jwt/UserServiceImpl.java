package tn.testTech.Service.jwt;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.User;
import tn.testTech.repository.UserRepository;
//userdetailsService pour chargé les données de l'utilisateurs de la base 
@Service
public class UserServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        tn.testTech.model.User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Utilisateur non existant: " + email));

        return new User(user.getEmail(), user.getPassword(), Collections.emptyList());//conversion de l'objet user en un objet UserDetails
        //Collections.emptyList() represente les autorisations et les roles des utilisateurs
    }
}
