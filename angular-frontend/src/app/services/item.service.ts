import { Injectable } from '@angular/core';
import {Observable, Subject} from "rxjs";
import {HttpClient} from "@angular/common/http";
import { Item } from "../classes/item";

const baseUrl = 'http://localhost:8080/api/items';

@Injectable({
  providedIn: 'root'
})
export class ItemService {

  private itemSubject = new Subject<any>();

  constructor(private http: HttpClient) {
  }

  // Alert System
  sendListUpdateAlert(itemMessage: string) {
    this.itemSubject.next({ text: itemMessage });
  }

  getListUpdateAlert(): Observable<any> {
    return this.itemSubject.asObservable();
  }
  // Alert System

  getAll(): Observable<Item[]> {
    return this.http.get<Item[]>(baseUrl);
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
}
