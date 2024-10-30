import { HttpClient, HttpHeaders } from '@angular/common/http'; //HttpClient : Utilisé pour envoyer des requêtes HTTP (POST, GET, etc.) au serveur.
//HttpHeaders : Permet de configurer des en-têtes HTTP, nécessaires ici pour ajouter un jeton d'autorisation.
import { Injectable } from '@angular/core';//Indique que JwtService peut être injecté dans d'autres composants ou services.
import { Observable } from 'rxjs';//Permet d'utiliser le concept de réactivité pour gérer les réponses asynchrones.
//Ce Service est utilisé pour envoyer les données du formulaire au serveur.

const BASE_URL = ["http://localhost:8080/"]

@Injectable({
  providedIn: 'root' // Rend le service global dans l'application. Il sera disponible dans toute l'application sans nécessiter de déclaration supplémentaire.
})
export class JwtService {

  constructor(private http: HttpClient) { }

  register(signRequest: any): Observable<any> { // register(signRequest: any) : Envoie une requête POST pour inscrire un utilisateur.
    //signRequest contient les données de formulaire 
    return this.http.post(BASE_URL + 'signup', signRequest)
  }

  login(loginRequest: any): Observable<any> {
    return this.http.post(BASE_URL + 'login', loginRequest)
  }

  
  private createAuhtorizationHeader() {
    const jwtToken = localStorage.getItem('jwt'); //localstorage élement TS stoque les données dans le navigateur et pas dans le serveur/backend
    if (jwtToken) {
      console.log("JWT token found in local storage", jwtToken); // msg  dans le console
      return new HttpHeaders().set(
        "Authorization", "Bearer " + jwtToken //BEarer c est le porté pour validdé l'identité des utilisateurs et les données les autorisation
      )
    } else {
      console.log("JWT token not found in local storage");
    }
    return null;
  }
  
  hello(): Observable<any> {
    const headers = this.createAuhtorizationHeader();  // Ajoute l'en-tête d'autorisation ici
    if (headers) {
      return this.http.get(BASE_URL + 'api/Etudiant/etu1', { headers });
    } else {
      console.error("JWT token is missing in local storage.");
      return new Observable<any>();  // Retourne un observable vide en cas de problème de token
    }
  }

}