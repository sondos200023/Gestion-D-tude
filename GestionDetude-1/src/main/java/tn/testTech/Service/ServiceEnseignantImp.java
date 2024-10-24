package tn.testTech.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.testTech.repository.RepositoryEnseignant;
import tn.testTech.model.*;

@Service
public class ServiceEnseignantImp implements IServiceEnseignant {
	 @Autowired
	    private RepositoryEnseignant enseignantRepository;

	    public List<Enseignant> getAllEnseignants() {
	        return enseignantRepository.findAll();
	    }

	    public Enseignant saveEnseignant(Enseignant enseignant) {
	        return enseignantRepository.save(enseignant);
	    }

	    public Optional<Enseignant> getEnseignantById(Long id) {
	        return enseignantRepository.findById(id);
	    }

	    public void deleteEnseignant(Long id) {
	        enseignantRepository.deleteById(id);
	    }
}
