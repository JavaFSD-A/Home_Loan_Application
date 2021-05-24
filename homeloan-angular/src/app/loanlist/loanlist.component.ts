/**
 * @author Vyshnavi
 * @description Loan Display 
 */

import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoanModel } from '../models/loan.model';
import { CustomerService } from '../services/customer.service';

@Component({
  selector: 'app-loanlist',
  templateUrl: './loanlist.component.html',
  styleUrls: ['./loanlist.component.css']
})
export class LoanlistComponent implements OnInit {
 loan : LoanModel;
 found : boolean;
  constructor(private service : CustomerService, private route : Router) { }

  ngOnInit(): void {
  }

  getLoanById() {
    this.service
      .findLoanById()
      .then((result : LoanModel)=> {
        this.loan = result;
        this.found = true;
        console.log(this.loan);
      });
  }
}
