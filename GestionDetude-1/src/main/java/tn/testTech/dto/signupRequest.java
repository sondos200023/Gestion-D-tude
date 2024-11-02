package tn.testTech.dto;
//package pour transférer les données entre la couche service et le controleur 
//DTO Data Transfert Object contient juste des attribus ,getters et setters et constructeurs pour utilisé les données nécessaire seulement
public class signupRequest {
	private String email;

    private String name;

    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}


