package tn.testTech.Controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import jakarta.servlet.http.HttpServletResponse;
import tn.testTech.Service.jwt.UserServiceImpl;
import tn.testTech.dto.LoginRequest;
import tn.testTech.dto.LoginResponse;
import tn.testTech.utils.JwtUtil;

@RestController
@RequestMapping("/login")
public class LoginController {

	  private final AuthenticationManager authenticationManager;

	    private final UserServiceImpl userService;

	    private final JwtUtil jwtUtil;


	    @Autowired
	    public LoginController(AuthenticationManager authenticationManager, UserServiceImpl userService, JwtUtil jwtUtil) {
	        this.authenticationManager = authenticationManager;
	        this.userService = userService;
	        this.jwtUtil = jwtUtil;
	    }

	    @PostMapping
	    public LoginResponse login(@RequestBody LoginRequest loginRequest, HttpServletResponse response) throws IOException {
	        try {
	            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));
	        } catch (BadCredentialsException e) {
	            throw new BadCredentialsException("Email ou mot de passe incorrect!!");
	        } catch (DisabledException disabledException) {
	            response.sendError(HttpServletResponse.SC_NOT_FOUND, "User n'est pas activé");
	            return null;
	        }
	        final UserDetails userDetails = userService.loadUserByUsername(loginRequest.getEmail());
	        final String jwt = jwtUtil.generateToken(userDetails.getUsername());

	        return new LoginResponse(jwt);
	    }

	}

