package tn.testTech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.testTech.model.Classe;
@Repository
public interface RepositoryClass extends JpaRepository<Classe,Long>{

}
