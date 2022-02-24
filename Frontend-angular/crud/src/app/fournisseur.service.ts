import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class FournisseurService {

  
  private baseUrl = 'http://localhost:1750'; 
  constructor(private http: HttpClient) { }

  getFournisseur(frId: String): Observable<any> {
    return this.http.get(`${this.baseUrl}/Fournisseurs/${frId}`);
  }

  addFournisseur(Fournisseur: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}/add/fournisseur`, Fournisseur);
  }

  updateFournisseur(frId: String, value: any): Observable<Object> {
    return this.http.put(`${this.baseUrl}/fournisseurs/update/${frId}`, value);
  }

  dellFournisseur(frId: String): Observable<any> { 
    return this.http.delete(`${this.baseUrl}/dell/Fournisseur/${frId}`, { responseType: 'text' });
  }

  getFournisseursList(): Observable<any> {
    return this.http.get(`${this.baseUrl}/Fournisseurs`); 
  } 
}
