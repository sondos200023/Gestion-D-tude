package tn.testTech.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tn.testTech.Service.ServiceEtudiantImp;
import tn.testTech.model.Etudiant;
import tn.testTech.repository.RepositoryClass;
import tn.testTech.repository.RepositoryEnseignant;
import tn.testTech.repository.RepositoryEtudiant;

@RestController
@RequestMapping("/api/Etudiant")
public class ControllerEtudiant {
	 @Autowired
	    private ServiceEtudiantImp etudiantService;
	@CrossOrigin(origins = "http://localhost:4200")
	 @GetMapping("/etu1")
	    public List<Etudiant> getAllStudents() {
	        return etudiantService.getAllEtudiants();
	         
	    }
	@GetMapping("/etu")
    public List<Etudiant> getEtudiantsByClasse(@RequestParam(required = false) String nomClasse) {
        return etudiantService.getEtudiantsByClasseNom(nomClasse);
    }
	@GetMapping("/etu2")
    public List<Etudiant> getEtudiantsByClasseAndEnseignant(@RequestParam(required = false) String nomClasse,
    		@RequestParam(required = false) String prenomEnseignant,
    		@RequestParam(required = false) String nomEnseignant) {
        return etudiantService.getEtudiantsByFilters(nomClasse,prenomEnseignant, nomEnseignant);
    }
	
	   /* @GetMapping("/etu1")
	    public List<Etudiant> getAllEtudiants1(
	            @RequestParam(required = false) String nomClasse,
	            @RequestParam(required = false) String nomEnseignant) {
	        return etudiantService.getEtudiantsByFilters(nomClasse, nomEnseignant);
	    }

	    @PostMapping
	    public Etudiant createEtudiant(@RequestBody Etudiant etudiant) {
	        return etudiantService.saveEtudiant(etudiant);
	    }

	    @GetMapping("/etu/{id}")
	    public ResponseEntity<Etudiant> getEtudiantById(@PathVariable Long id) {
	        return etudiantService.getEtudiantById(id)
	                .map(ResponseEntity::ok)
	                .orElse(ResponseEntity.notFound().build());
	    }

	    @DeleteMapping("/etu/{id}")
	    public ResponseEntity<Void> deleteEtudiant(@PathVariable Long id) {
	        etudiantService.deleteEtudiant(id);
	        return ResponseEntity.noContent().build();
	    }*/
	}

