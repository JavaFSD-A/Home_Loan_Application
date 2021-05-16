import { Component, OnInit } from '@angular/core';
import { CalculatorModel } from '../models/eligiblityCal.model';
import { CalculatorService } from '../services/calculator.service';
@Component({
  selector: 'app-eligiblitycal',
  templateUrl: './eligiblitycal.component.html',
  styleUrls: ['./eligiblitycal.component.css']
})
export class EligiblitycalComponent implements OnInit {

  calculator : CalculatorModel;
  constructor(private service : CalculatorService) {
    this.calculator = new CalculatorModel();
   }

  ngOnInit(): void {
  }

  eligiblity(){
      this.service.eligiblityCheck(this.calculator).then((result: CalculatorModel)=>{
        this.calculator = result;
        console.log(JSON.stringify(result));
      });
      
  }
}
