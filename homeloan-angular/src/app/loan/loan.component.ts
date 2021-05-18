import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoanModel } from '../models/loan.model';
import { CustomerService } from '../services/customer.service';

@Component({
  selector: 'app-loan',
  templateUrl: './loan.component.html',
  styleUrls: ['./loan.component.css']
})
export class LoanComponent implements OnInit {

  loan : LoanModel;
  loan_names : string[];
  loan_tenures : number[];


  constructor(private service : CustomerService, private route : Router) {
    this.loan = new LoanModel();
    this.loan_names = ["Loan for Home Purchase","Loan for Land Purchase","Bridge HomeLoan"];
    this.loan_tenures = [1,5,10,15,20];
   }

  ngOnInit(): void {
 
}

  addLoan(){
    this.service.createLoan(this.loan);
  }

}

