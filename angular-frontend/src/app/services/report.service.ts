import { Injectable } from '@angular/core';
import { Observable, Subject } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Report } from '../classes/report';

const baseUrl = 'http://localhost:8080/api/reports';

@Injectable({
  providedIn: 'root'
})
export class ReportService {
  private reportSubject = new Subject<any>();

  constructor(private http: HttpClient) {
  }

  // Alert System
  sendListUpdateAlert(reportMessage: string) {
    this.reportSubject.next({ text: reportMessage });
  }

  getListUpdateAlert(): Observable<any> {
    return this.reportSubject.asObservable();
  }
  // Alert System

  getAll(): Observable<Report[]> {
    return this.http.get<Report[]>(baseUrl);
  }

  get(id: any): Observable<any> {
    return this.http.get(`${ baseUrl }/${ id }`);
  }

  create(data: any): Observable<any> {
    return this.http.post(baseUrl, data);
  }

  update(id: any, data: any): Observable<any> {
    return this.http.put(`${ baseUrl }/${ id }`, data);
  }

  delete(id: any): Observable<any> {
    return this.http.delete(`${ baseUrl }/${ id }`);
  }

  deleteAll(): Observable<any> {
    return this.http.delete(baseUrl);
  }

  findReportByPatientId(patientId: any): Observable<Report[]> {
    return this.http.get<Report[]>(`${ baseUrl }/patient/${ patientId }`);
  }

  findReportByNameDob(namedob: any): Observable<any> {
    return this.http.post(`${ baseUrl }/namedob`, namedob);
  }

}
