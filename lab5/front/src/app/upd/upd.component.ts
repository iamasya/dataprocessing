import { Component, OnInit, Input, Output } from '@angular/core';
import { Instrument } from '../interfaces/instrument';
import { Service1Service } from '../services/service1.service';

@Component({
  selector: 'app-upd',
  templateUrl: './upd.component.html',
  styleUrls: ['./upd.component.scss']
})
export class UpdComponent implements OnInit {

  instrumentList:Instrument[]=[];

  selectedItem?:Instrument;

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
  
  onSelect(instrument:Instrument){
    this.selectedItem=instrument;
  }
  
  updateRest(instrument:Instrument){
    this.service.putRest(this.selectedItem!._links.self.href, instrument).subscribe(
      ()=>{
        this.getRest();
      }
    )
  }

}
