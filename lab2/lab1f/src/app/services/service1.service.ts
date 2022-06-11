import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Entity } from '../interfaces/entity';

@Injectable({
  providedIn: 'root'
})
export class Service1Service {
url: string = "http://localhost:8081/lab1/InstrumentServlet"

  constructor(private http:HttpClient) { }

  getEntities():Observable<Entity[]>{
    return this.http.get<Entity[]>(this.url);
  }

  setEntities(params: any):Observable<Object> {
    return this.http.put(this.url, {}, { params: params });
  }

}