import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

const BASE_URL = ["http://localhost:8080/"]

@Injectable({
  providedIn: 'root'
})
export class JwtService {

  constructor(private http: HttpClient) { }

  register(signRequest: any): Observable<any> {
    return this.http.post(BASE_URL + 'signup', signRequest)
  }

  login(loginRequest: any): Observable<any> {
    return this.http.post(BASE_URL + 'login', loginRequest)
  }

  
  private createAuhtorizationHeader() {
    const jwtToken = localStorage.getItem('jwt');
    if (jwtToken) {
      console.log("JWT token found in local storage", jwtToken);
      return new HttpHeaders().set(
        "Authorization", "Bearer " + jwtToken
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