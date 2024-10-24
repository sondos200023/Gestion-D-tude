package tn.testTech.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.testTech.Service.ServiceEnseignantImp;
import tn.testTech.model.Enseignant;
@RestController
@RequestMapping("/api/Enseignant")
public class ControllerEnseignant {
	 @Autowired
	    private ServiceEnseignantImp enseignantService;

	    @GetMapping
	    public List<Enseignant> getAllEnseignants() {
	        return enseignantService.getAllEnseignants();
	    }

	    @PostMapping
	    public Enseignant createEnseignant(@RequestBody Enseignant enseignant) {
	        return enseignantService.saveEnseignant(enseignant);
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<Enseignant> getEnseignantById(@PathVariable Long id) {
	        return enseignantService.getEnseignantById(id)
	                .map(ResponseEntity::ok)
	                .orElse(ResponseEntity.notFound().build());
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteEnseignant(@PathVariable Long id) {
	        enseignantService.deleteEnseignant(id);
	        return ResponseEntity.noContent().build();
	    }
	}
