import { ClassMethod } from '@angular/compiler';
import { Component, OnInit } from '@angular/core';
import { CalculatorModel } from '../calculator.model';
import { CalculatorService } from '../services/calculator.service';

@Component({
  selector: 'app-calculator',
  templateUrl: './calculator.component.html',
  styleUrls: ['./calculator.component.css']
})
export class CalculatorComponent implements OnInit {

  calculator : CalculatorModel;
  constructor(private service : CalculatorService) {
    this.calculator = new CalculatorModel();
   }

  ngOnInit(): void {
  }

  eligiblity(){
      this.service.eligiblityCheck(this.calculator);
  }

}
