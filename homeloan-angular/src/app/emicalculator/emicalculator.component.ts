/**
 * @author Tarishi G.
 * @description EMI Calculator
 */

import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { EmiCalculatorModel } from '../models/emiCal.model';
import { CalculatorService } from '../services/calculator.service';

@Component({
  selector: 'app-emicalculator',
  templateUrl: './emicalculator.component.html',
  styleUrls: ['./emicalculator.component.css']
})
export class EmicalculatorComponent implements OnInit {


  emiCal : EmiCalculatorModel;

  constructor(private service : CalculatorService, private route : Router ) {
    this.emiCal = new EmiCalculatorModel();
   }

  ngOnInit(): void {
  }

  fixedEmi(){
    this.service.fixedEmi(this.emiCal).then((result: EmiCalculatorModel)=>{
      this.emiCal = result;
      console.log(JSON.stringify(result));
    });
    
}
  reducingEmi(){
  this.service.reducingEmi(this.emiCal).then((result: EmiCalculatorModel)=>{
    this.emiCal = result;
    console.log(JSON.stringify(result));
  });
  
}
}
