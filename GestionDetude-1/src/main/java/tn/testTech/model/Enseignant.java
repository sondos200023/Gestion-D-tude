package tn.testTech.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//@AllArgsConstructor
//@NoArgsConstructor
//@Data
@Entity
public class Enseignant {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Long id;
	private String prenom,nomDeFamille;
/*@OneToOne
@JoinColumn(name = "id_classe")
private Classe classe;*/
	
	public Long getId() {
		return id;
	}
	public Enseignant() {
	super();
}
	public Enseignant(Long id, String prenom, String nomDeFamille) {
	super();
	this.id = id;
	this.prenom = prenom;
	this.nomDeFamille = nomDeFamille;
}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getNomDeFamille() {
		return nomDeFamille;
	}
	public void setNomDeFamille(String nomDeFamille) {
		this.nomDeFamille = nomDeFamille;
	}
	
}
