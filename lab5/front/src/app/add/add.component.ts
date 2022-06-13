import { Component, OnInit, Input, Output } from '@angular/core';
import { Instrument } from '../interfaces/instrument';
import { Service1Service } from '../services/service1.service';

@Component({
  selector: 'app-add',
  templateUrl: './add.component.html',
  styleUrls: ['./add.component.scss']
})

export class AddComponent implements OnInit {

  instrumentList:Instrument[]=[];

  constructor(private service:Service1Service) { }

  ngOnInit(): void {
  }

  getRest():void{
    this.service.getRest().subscribe(
      (rest1)=>{
        this.instrumentList=rest1._embedded.instruments;
      }
    )
  }

  addRest(instrument:Instrument){
    this.service.postRest(instrument).subscribe(
      ()=>{
        this.getRest();
      }
    )
  }

}
