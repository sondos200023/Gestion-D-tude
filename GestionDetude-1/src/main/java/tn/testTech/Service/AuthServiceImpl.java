package tn.testTech.Service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import tn.testTech.dto.signupRequest;
import tn.testTech.model.User;
import tn.testTech.repository.UserRepository;



@Service
public class AuthServiceImpl  implements AuthService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AuthServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public User createUser(signupRequest signupRequest) {
        if (userRepository.existsByEmail(signupRequest.getEmail())) {
            return null; //car si un email existant un erreur se fait 
        }

        User user = new User();
        BeanUtils.copyProperties(signupRequest,user);//opié tous les proprieté de dto signupRequest dans l'objet user 

        String hashPassword = passwordEncoder.encode(signupRequest.getPassword()); //chiffrement
        user.setPassword(hashPassword);
        User createdUser = userRepository.save(user); //sauvegard dans la base de données 
        user.setId(createdUser.getId());
        return user;
    }
}
