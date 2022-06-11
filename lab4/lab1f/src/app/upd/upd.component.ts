import { Component, OnInit } from '@angular/core';
import { Entity } from '../interfaces/entity';
import { Service1Service } from '../services/service1.service';

@Component({
  selector: 'app-upd',
  templateUrl: './upd.component.html',
  styleUrls: ['./upd.component.scss']
})
export class UpdComponent implements OnInit {

  instrumentList:Entity[]=[];

  constructor(private service:Service1Service) { }

  ngOnInit(): void {
    this.getEntities();
  }

  getEntities():void{
    this.service.getEntities().subscribe(
      (entity)=>{
        this.instrumentList=entity;
        this.service.setList(entity);
      }
    )
  }

  updEntities(entity:Entity){
    this.service.putEntities(entity).subscribe(
      ()=>{
        this.getEntities();
      }
    )
  }

}
