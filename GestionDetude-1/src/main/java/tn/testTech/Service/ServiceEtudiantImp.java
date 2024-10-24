package tn.testTech.Service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.*;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import tn.testTech.repository.RepositoryEtudiant;
import tn.testTech.model.Etudiant;

@Service
public class ServiceEtudiantImp {

@Autowired
private RepositoryEtudiant etudiantRepository;

public List<Etudiant> getAllEtudiants() {
    return etudiantRepository.findAll();

}
public List<Etudiant> getEtudiantsByClasseNom(String nomClasse) {
    return etudiantRepository.findEtudiantsByClasseNom(nomClasse);
}


public List<Etudiant> getEtudiantsByFilters(String nomClasse, String nomEnseignant, String prenomEnseignant) {
    if (nomClasse != null && nomEnseignant != null && prenomEnseignant != null) {
        return etudiantRepository.findEtudiantsByFilters(nomClasse, prenomEnseignant ,nomEnseignant);
    }
    else if (nomClasse != null && nomEnseignant == null && prenomEnseignant == null) {
        return etudiantRepository.findEtudiantsByClasseNom(nomClasse);
    }
    else if (nomEnseignant != null && prenomEnseignant != null && nomClasse == null) {
        return etudiantRepository.findEtudiantsByEnseignantNom(prenomEnseignant, nomEnseignant);
    }else {
    return etudiantRepository.findAll();}

}


public Etudiant saveEtudiant(Etudiant etudiant) {
    return etudiantRepository.save(etudiant);
}

public Optional<Etudiant> getEtudiantById(Long id) {
    return etudiantRepository.findById(id);
}

public void deleteEtudiant(Long id) {
    etudiantRepository.deleteById(id);
}
}


