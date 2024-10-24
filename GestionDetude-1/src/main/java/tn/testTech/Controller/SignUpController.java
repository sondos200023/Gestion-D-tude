package tn.testTech.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.testTech.Service.AuthService;
import tn.testTech.dto.signupRequest;
import tn.testTech.model.*;

@RestController
@RequestMapping("/signup")
public class SignUpController {
	 private final AuthService authService;

	    public SignUpController(AuthService authService) {
	        this.authService = authService;
	    }

	    @PostMapping
	    public ResponseEntity<?> signupUser(@RequestBody signupRequest signupRequest) {
	        User createdUser = authService.createUser(signupRequest);
	        if (createdUser != null) {
	            return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
	        } else {
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("erreur lors de création du compte");
	        }
	    }

	}


