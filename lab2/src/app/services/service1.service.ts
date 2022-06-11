import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Entity } from '../interfaces/entity';

@Injectable({
  providedIn: 'root'
})
export class Service1Service {
url: string = "/lab1/Servlet1"

  constructor(private http:HttpClient) { }

  getEntities():Observable<Entity[]>{
    return this.http.get<Entity[]>(this.url);
  }

}