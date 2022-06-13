import { Component } from '@angular/core';
import { Instrument } from './interfaces/instrument';
import { Service1Service } from './services/service1.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})

export class AppComponent {
  title = 'front';
  instrument:Instrument[]=[];

}
