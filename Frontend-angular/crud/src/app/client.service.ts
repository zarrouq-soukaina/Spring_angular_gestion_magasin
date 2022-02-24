import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class ClientService {

  
  private baseUrl = 'http://localhost:1750'; 
  constructor(private http: HttpClient) { } 

  getClient(cId: String): Observable<any> {
    return this.http.get(`${this.baseUrl}/Clients/${cId}`);
  }

  addClient(Client: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}/add/client`, Client);
  }

  updateClient(cId: String, value: any): Observable<Object> {
    return this.http.put(`${this.baseUrl}/clients/update/${cId}`, value);
  }

  dellClient(cId: String): Observable<any> { 
    return this.http.delete(`${this.baseUrl}/dell/Client/${cId}`, { responseType: 'text' }); 
  }

  getClientsList(): Observable<any> {
    return this.http.get(`${this.baseUrl}/Clients`);
  } 
}
