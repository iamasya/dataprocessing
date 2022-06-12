import { Component, OnInit } from '@angular/core';
import { Entity } from '../interfaces/entity';
import { Service1Service } from '../services/service1.service';

@Component({
  selector: 'app-add',
  templateUrl: './add.component.html',
  styleUrls: ['./add.component.scss']
})
export class AddComponent implements OnInit {

  instrumentList:Entity[]=[];

  constructor(private service:Service1Service) { }

  ngOnInit(): void {
  }

  getRest():void{
    this.service.getRest().subscribe(
      (rest1)=>{
        this.instrumentList=rest1._embedded.entities;
      }
    )
  }

  addRest(entity:Entity){
    this.service.postRest(entity).subscribe(
      ()=>{
        this.getRest();
      }
    )
  }

}
