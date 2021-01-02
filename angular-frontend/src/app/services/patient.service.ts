import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import { Observable, from } from 'rxjs';

const baseUrl = 'http://localhost:8080/api/patients';
const nameDob = 'http://localhost:8080/api/patients/namedob/';


@Injectable({
  providedIn: 'root'
})
export class PatientService {

  constructor(private http: HttpClient) { }

  getAll(): Observable<any> {
    return this.http.get(baseUrl);
  }

  get(id: string): Observable<any> {
    return this.http.get(`${baseUrl}/${id}`);
  }

  create(data: object): Observable<object> {
    return this.http.post(baseUrl, data);
  }

  update(id: string, data: object): Observable<object> {
    return this.http.put(`${baseUrl}/${id}`, data);
  }

  delete(id: string): Observable<any> {
    return this.http.delete(`${baseUrl}/${id}`);
  }

  deleteAll(): Observable<any> {
    return this.http.delete(baseUrl);
  }

  //findByTitle(title: string): Observable<any> {
  //  return this.http.get(`${baseUrl}?title=${title}`);
  // }
  findByPatientName(name:string) : Observable<any>{
    return this.http.get(`${baseUrl}?name=${name}`);
  }

  findByPatientNameDob(patient_name:string, patient_dob:Date): Observable<object> {
    return this.http.post(nameDob,patient_name+patient_dob);
  }

}
