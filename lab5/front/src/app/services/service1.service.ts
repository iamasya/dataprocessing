import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Rest1 } from '../interfaces/rest1';
import { Instrument } from '../interfaces/instrument';

@Injectable({
  providedIn: 'root'
})
export class Service1Service {

  url:string="http://localhost:1155/instruments"

  constructor(private http:HttpClient) { }

  getRest():Observable<Rest1>{
    return this.http.get<Rest1>(this.url);
  }

  postRest(instrument:Instrument):Observable<Instrument>{
    return this.http.post<Instrument>(this.url, instrument);
  }
  putRest(link:string, instrument:Instrument):Observable<Instrument>{
    return this.http.put<Instrument>(link, instrument);
  }
  deleteRest(instrument:Instrument):Observable<Instrument>{
    return this.http.delete<Instrument>(instrument._links.self.href)
  }

}
