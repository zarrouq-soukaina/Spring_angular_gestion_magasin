import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class FactureService {

  
  private baseUrl = 'http://localhost:1750'; 
  constructor(private http: HttpClient) { }

  getFacture(fId: String): Observable<any> {
    return this.http.get(`${this.baseUrl}/Factures/${fId}`);
  }

  addFacture(facture: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}/add/facture/`, facture);
  }

  updateFacture(fId: String, value: any): Observable<Object> {
    return this.http.put(`${this.baseUrl}/factures/update/${fId}`, value);
  }

  dellFacture(fId: String): Observable<any> {
    return this.http.delete(`${this.baseUrl}/dell/Facture/${fId}`, { responseType: 'text' });
  }

  getFacturesList(): Observable<any> {
    return this.http.get(`${this.baseUrl}/Factures`);  
  }
}
