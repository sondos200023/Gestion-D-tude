package tn.testTech.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.websocket.OnClose;
import lombok.*;
//@AllArgsConstructor
//@NoArgsConstructor
//@Data
@Entity
public class Classe {
@Id
@GeneratedValue(strategy =GenerationType.IDENTITY)
private Long id;
private String nom;
@ManyToOne
@JoinColumn(name = "enseignant_id") 
private Enseignant enseignant;
@OneToMany(mappedBy = "classe")
private List<Etudiant> Letudiants;
public Long getId() {
	return id;
}

public Classe() {
	super();
}

public Classe(Long id, String nom, Enseignant enseignant, List<Etudiant> letudiants) {
	super();
	this.id = id;
	this.nom = nom;
	this.enseignant = enseignant;
	Letudiants = letudiants;
}

public void setId(Long id) {
	this.id = id;
}
public String getNom() {
	return nom;
}
public void setNom(String nom) {
	this.nom = nom;
}

public void setEnseignant(Enseignant enseignant) {
	this.enseignant = enseignant;
}

public void setLetudiants(List<Etudiant> letudiants) {
	Letudiants = letudiants;
}

}
