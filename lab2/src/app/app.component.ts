import { Component } from '@angular/core';
import { Entity } from './interfaces/entity';
import { Service1Service } from './services/service1.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'lab1f';
  entityList:Entity[]=[];

  constructor(private services:Service1Service){}

  getEntities():void{
    this.services.getEntities().subscribe(
      (entities)=>{
        this.entityList = entities;
      }
    )
  }
}
