package tn.testTech.repository;


import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import tn.testTech.model.Etudiant;
@Repository
public interface RepositoryEtudiant extends JpaRepository<Etudiant,Long>{
    @Query("SELECT e FROM Etudiant e JOIN e.classe c WHERE c.nom = :nomClasse")
    List<Etudiant> findEtudiantsByClasseNom(@Param("nomClasse") String nomClasse);
    @Query("SELECT e FROM Etudiant e JOIN e.enseignant ens WHERE ens.prenom = :prenomEnseignant AND ens.nomDeFamille= :nomEnseignant")
    List<Etudiant> findEtudiantsByEnseignantNom(@Param("prenomEnseignant") String prenomEnseignant, @Param("nomEnseignant") String nomEnseignant);

    @Query("SELECT e FROM Etudiant e WHERE (e.classe.nom = :nomClasse) " +
           "AND (e.enseignant.nomDeFamille = :nomEnseignant) " +
           "AND (e.enseignant.prenom = :prenomEnseignant)")
    List<Etudiant> findEtudiantsByFilters(@Param("nomClasse") String nomClasse,
                                           @Param("nomEnseignant") String prenomEnseignant,
                                           @Param("prenomEnseignant") String nomEnseignant);
	}