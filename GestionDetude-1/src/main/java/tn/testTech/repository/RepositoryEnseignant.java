package tn.testTech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.testTech.model.Enseignant;
@Repository
public interface RepositoryEnseignant extends JpaRepository<Enseignant, Long>{

}
