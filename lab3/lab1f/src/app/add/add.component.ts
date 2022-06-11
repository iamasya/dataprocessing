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

  getEntities():void{
    this.service.getEntities().subscribe(
      (entity)=>{
        this.instrumentList=entity;
        this.service.setList(entity);
      }
    )
  }

  addEntities(entity:Entity){
    this.service.postEntities(entity).subscribe(
      ()=>{
        this.getEntities();
      }
    )
  }

}
