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

  removeEntities(entity:Entity){
    this.service.deleteEntities(entity).subscribe(
      ()=>{
        this.getEntities();
      }
    )
  }

}
