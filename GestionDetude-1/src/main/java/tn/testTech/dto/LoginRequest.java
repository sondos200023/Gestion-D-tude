package tn.testTech.dto;

public class LoginRequest {
	//    @NotBlank(message = "L'email est obligatoire")
	 private String email;

	    private String password;

	    public String getEmail() {
	        return email;
	    }

	    public void setEmail(String email) {
	        this.email = email;
	    }

	    public String getPassword() {
	        return password;
	    }

	    public void setPassword(String password) {
	        this.password = password;
	    }
	}

