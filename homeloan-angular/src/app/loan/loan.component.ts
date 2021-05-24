/**
 * @author Vyshnavi
 * @description Loan Save Form 
 */

import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CapitalModel } from '../models/capital.model';
import { LoanModel } from '../models/loan.model';

import { CustomerService } from '../services/customer.service';

@Component({
  selector: 'app-loan',
  templateUrl: './loan.component.html',
  styleUrls: ['./loan.component.css']
})
export class LoanComponent implements OnInit {

  loan : LoanModel;
  capital:CapitalModel;
  loan_names : string[];
  loan_tenures : number[];


  constructor(private service : CustomerService, private route : Router) {
    this.loan = new LoanModel();
    this.capital=new CapitalModel();
    this.loan_names = ["Loan for Home Purchase","Loan for Land Purchase","Bridge HomeLoan","NRI HomeLoan"];
    this.loan_tenures = [1,3,5,10,20,25];
   }

  ngOnInit(): void {
    
}

  addLoan(){
    this.service.createLoan(this.loan);
    alert("Loan Detail Saved!!");
    this.route.navigate(['authdoc']);
  }

}

