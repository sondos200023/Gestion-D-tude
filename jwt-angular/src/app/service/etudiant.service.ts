// etudiant.service.ts
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

const BASE_URL = "http://localhost:8080/api";  // L'URL de base de ton API

@Injectable({
  providedIn: 'root'
})
export class EtudiantService {

  constructor(private http: HttpClient) { }

  // Méthode pour récupérer la liste des étudiants
  /*getEtudiants(): Observable<any> {
    const headers = this.createAuthorizationHeader();
    if (headers) {
      return this.http.get(`${BASE_URL}/Etudiant/etu1`, { headers });
    } else {
      console.error("JWT token is missing in local storage.");
      return new Observable<any>();  // Retourne un observable vide si le jeton est manquant
    }
  }*/
  getEtudiants(nomClasse: string, nomEnseignant: string, prenomEnseignant: string): Observable<any> {
    const headers = this.createAuthorizationHeader();
    const params = {
      nomClasse: nomClasse || null,  
      nomEnseignant: nomEnseignant || null,
      prenomEnseignant: prenomEnseignant || null
    };
  
    if (headers) {
      return this.http.get(`${BASE_URL}/Etudiant/etu2`, { headers, params });
    } else {
      console.error("JWT token is missing in local storage.");
      return new Observable<any>();  // Retourne un observable vide si le jeton est manquant
    }
  }

  // Méthode pour créer l'en-tête d'autorisation avec le token JWT
  private createAuthorizationHeader() {
    const jwtToken = localStorage.getItem('jwt');  // Récupère le jeton depuis le localStorage
    if (jwtToken) {
      return new HttpHeaders().set("Authorization", "Bearer " + jwtToken);  // Crée l'en-tête d'autorisation
    } else {
      return null;
    }
  }
}
