import { Component, OnInit } from '@angular/core';
import { EtudiantService } from '../../service/etudiant.service';
import { Etudiant } from '../../models/etudiant';

@Component({
  selector: 'app-etudiant-list',
  templateUrl: './etudiant-list.component.html',
  styleUrls: ['./etudiant-list.component.scss']
})
export class EtudiantListComponent implements OnInit {

  etudiants: any[] = []; 
  nomClasse: string = null;
  nomEnseignant: string = null;
  prenomEnseignant: string = null;

  constructor(private etudiantService: EtudiantService) { }

  ngOnInit(): void {
    this.fetchEtudiants();  
  }

  fetchEtudiants() {
    
    this.etudiantService.getEtudiants(this.nomClasse, this.nomEnseignant, this.prenomEnseignant).subscribe({
      next: (data) => {
        this.etudiants = data;  
        console.log("Liste des étudiants récupérée avec succès:", data);
      },
      error: (err) => {
        console.error("Erreur lors de la récupération des étudiants:", err);
      }
    });
  }
}
