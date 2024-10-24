package tn.testTech.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
public class Etudiant {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Long id;
	private String prenom,nomDeFamille;
@ManyToOne
@JoinColumn(name = "class_id")
private Classe classe;
@ManyToOne
@JoinColumn(name = "enseignant_id")
private Enseignant enseignant;

public Etudiant() {
	super();
}
public Etudiant(Long id, String prenom, String nomDeFamille, Classe classe, Enseignant enseignant) {
	super();
	this.id = id;
	this.prenom = prenom;
	this.nomDeFamille = nomDeFamille;
	this.classe = classe;
	this.enseignant = enseignant;
}
/*public Classe getClasse() {
	return classe;
}
public Enseignant getEnseignant() {
	return enseignant;
}*/
public Long getId() {
	return id;
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

public void setClasse(Classe classe) {
	this.classe = classe;
}

public void setEnseignant(Enseignant enseignant) {
	this.enseignant = enseignant;
}

}
