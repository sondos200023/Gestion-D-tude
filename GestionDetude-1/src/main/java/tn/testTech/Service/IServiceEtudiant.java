package tn.testTech.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import tn.testTech.model.Etudiant;

public interface IServiceEtudiant {
	public List<Etudiant> getAllEtudiants();
	public List<Etudiant> getEtudiantsByFilters(String nomClasse, String nomEnseignant,String PrenomEnseignant);
	public Etudiant saveEtudiant(Etudiant etudiant);
	public Optional<Etudiant> getEtudiantById(Long id);
	public void deleteEtudiant(Long id);
}
