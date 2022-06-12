import { Component, OnInit } from '@angular/core';
import { Entity } from '../interfaces/entity';
import { Service1Service } from '../services/service1.service';

@Component({
  selector: 'app-rm',
  templateUrl: './rm.component.html',
  styleUrls: ['./rm.component.scss']
})
export class RmComponent implements OnInit {

  instrumentList:Entity[]=[];

  constructor(private service:Service1Service) { }

  ngOnInit(): void {
    this.getRest();
  }

  getRest():void{
    this.service.getRest().subscribe(
      (rest1)=>{
        this.instrumentList=rest1._embedded.entities;
      }
    )
  }

  removeRest(entity:Entity){
    this.service.deleteRest(entity).subscribe(
      ()=>{
        this.getRest();
      }
    )
  }

}
