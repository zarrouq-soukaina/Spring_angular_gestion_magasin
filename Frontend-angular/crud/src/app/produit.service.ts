import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class ProduitService {

  
  private baseUrl = 'http://localhost:1750'; 
  constructor(private http: HttpClient) { }  

  getProduit(pId: String): Observable<any> {
    return this.http.get(`${this.baseUrl}/Produits/get/${pId}`);
  }

  addProduit(produit: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}/add/prodit/`, produit);
  }

  updateProduit(pId: String, value: any): Observable<Object> {
    return this.http.put(`${this.baseUrl}/produits/update/${pId}`, value);
  }

  dellProduit(pId: String): Observable<any> {
    return this.http.delete(`${this.baseUrl}/dell/produit/${pId}`, { responseType: 'text' });
  }

  getProduitsList(): Observable<any> {
    return this.http.get(`${this.baseUrl}/Produits`);
  }
}
