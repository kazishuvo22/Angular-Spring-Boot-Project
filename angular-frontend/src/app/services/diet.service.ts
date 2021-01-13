import { Injectable } from '@angular/core';
import { Observable, Subject } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Diet } from "../classes/diet";

const baseUrl = 'http://localhost:8080/api/diets';

@Injectable({
  providedIn: 'root'
})
export class DietService {
  private dietSubject = new Subject<any>();

  constructor(private http: HttpClient) {
  }

  // Alert System
  sendListUpdateAlert(dietMessage: string) {
    this.dietSubject.next({ text: dietMessage });
  }

  getListUpdateAlert(): Observable<any> {
    return this.dietSubject.asObservable();
  }
  // Alert System

  getAll(): Observable<Diet[]> {
    return this.http.get<Diet[]>(baseUrl);
  }

  get(id: any): Observable<any> {
    return this.http.get(`${ baseUrl }/${ id }`);
  }

  create(data: any): Observable<any> {
    return this.http.post(baseUrl, data);
  }

  delete(id: any): Observable<any> {
    return this.http.delete(`${ baseUrl }/${ id }`);
  }

  deleteAll(): Observable<any> {
    return this.http.delete(baseUrl);
  }

}
