import { Component, OnInit } from '@angular/core';
import { Instrument } from '../interfaces/instrument';
import { Service1Service } from '../services/service1.service';

@Component({
  selector: 'app-rm',
  templateUrl: './rm.component.html',
  styleUrls: ['./rm.component.scss']
})
export class RmComponent implements OnInit {

  instrumentList:Instrument[]=[];

  constructor(private service:Service1Service) { }

  ngOnInit(): void {
    this.getRest();
  }

  getRest():void{
    this.service.getRest().subscribe(
      (rest1)=>{
        this.instrumentList=rest1._embedded.instruments;
      }
    )
  }
  
  removeRest(instrument:Instrument){
    this.service.deleteRest(instrument).subscribe(
      ()=>{
        this.getRest();
      }
    )
  }

}
