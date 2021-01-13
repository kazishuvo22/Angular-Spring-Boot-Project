import { Injectable } from '@angular/core';
import { Observable, Subject } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import {Medicine} from "../classes/medicine";

const baseUrl = 'http://localhost:8080/api/medicins';

@Injectable({
  providedIn: 'root'
})
export class MedicinService {
  private medicinSubject = new Subject<any>();

  constructor(private http: HttpClient) {
  }

  // Alert System
  sendListUpdateAlert(medicinMessage: string) {
    this.medicinSubject.next({ text: medicinMessage });
  }

  getListUpdateAlert(): Observable<any> {
    return this.medicinSubject.asObservable();
  }
  // Alert System

  getAll(): Observable<Medicine[]> {
    return this.http.get<Medicine[]>(baseUrl);
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
