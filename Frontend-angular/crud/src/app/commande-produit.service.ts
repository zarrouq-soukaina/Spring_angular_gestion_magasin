import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class CommandeProduitService {

  
  private baseUrl = 'http://localhost:1750'; 
  constructor(private http: HttpClient) { }

  getCommandeProduit(id: String): Observable<any> {
    return this.http.get(`${this.baseUrl}/CommandeProduits/${id}`); 
  }

  addCommandeProduit(CommandeProduit: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}/add/commandeProduit`, CommandeProduit);
  }

  updateCommandeProduit(id: String, value: any): Observable<Object> {
    return this.http.put(`${this.baseUrl}/commandeProduits/update/${id}`, value);
  }

  dellCommandeProduit(id: String): Observable<any> { 
    return this.http.delete(`${this.baseUrl}/dell/CommandeProduit/${id}`, { responseType: 'text' });
  }

  getCommandeProduitsList(): Observable<any> {
    return this.http.get(`${this.baseUrl}/CommandeProduits`);
  } 
}
