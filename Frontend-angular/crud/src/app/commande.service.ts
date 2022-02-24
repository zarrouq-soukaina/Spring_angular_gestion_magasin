import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class CommandeService {

  
  private baseUrl = 'http://localhost:1750';  
  constructor(private http: HttpClient) { }

  getCommande(cmId: String): Observable<any> {
    return this.http.get(`${this.baseUrl}/Commandes/${cmId}`);
  }

  addCommande(Commande: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}/add/commande`, Commande);
  }

  updateCommande(cmId: String, value: any): Observable<Object> {
    return this.http.put(`${this.baseUrl}/commandes/update/${cmId}`, value);
  }

  dellCommande(cmId: String): Observable<any> { 
    return this.http.delete(`${this.baseUrl}/dell/Commande/${cmId}`, { responseType: 'text' });
  }

  getCommandesList(): Observable<any> {
    return this.http.get(`${this.baseUrl}/Commandes`);
  } 
}
