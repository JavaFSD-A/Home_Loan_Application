/**
 * @author S SatyaSri
 * @description Capital Save Form 
 */

import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CapitalModel } from '../models/capital.model';
import { CustomerService } from '../services/customer.service';

@Component({
  selector: 'app-capitaldetails',
  templateUrl: './capitaldetails.component.html',
  styleUrls: ['./capitaldetails.component.css']
})
export class CapitaldetailsComponent implements OnInit {
 
  capital : CapitalModel;

  constructor(private service : CustomerService, private route : Router) {
    this.capital = new CapitalModel();
   }

  ngOnInit(): void {
   
}

  addCapital(){
    this.service.createCapital(this.capital);
    alert("Property & Income Details Saved!!")
    this.route.navigate(['loan']);
  }

}
