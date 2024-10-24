package tn.testTech.Service;

import java.util.List;
import java.util.Optional;

import tn.testTech.model.Enseignant;

public interface IServiceEnseignant {
	public List<Enseignant> getAllEnseignants();
	public Enseignant saveEnseignant(Enseignant enseignant);
	 public Optional<Enseignant> getEnseignantById(Long id);
	 public void deleteEnseignant(Long id);
}
