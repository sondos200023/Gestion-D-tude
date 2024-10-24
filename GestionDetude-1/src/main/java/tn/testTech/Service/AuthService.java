package tn.testTech.Service;

import tn.testTech.*;
import tn.testTech.dto.signupRequest;
import tn.testTech.model.User;

public interface AuthService {
	 User createUser(signupRequest signupRequest);

}
