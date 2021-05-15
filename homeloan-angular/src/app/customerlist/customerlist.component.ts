import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CustomerModel } from '../customer.model';
import { LoanModel } from '../loan.model';
import { LoanComponent } from '../loan/loan.component';
import { LoanlistComponent } from '../loanlist/loanlist.component';
import { CustomerService } from '../services/customer.service';


@Component({
  selector: 'app-customerlist',
  templateUrl: './customerlist.component.html',
  styleUrls: ['./customerlist.component.css'],
})
export class CustomerlistComponent implements OnInit {
  customer_id: number;
  customer: CustomerModel;
  found: boolean;
  loan : LoanModel;

  constructor(
    private service: CustomerService,
    private route: Router
  ) {}

  ngOnInit(): void {
    if (localStorage.getItem('customer') == null) {
      this.route.navigate(['login']);
    }
  }

  getCustomerById() {
    this.service.customerById().then((list: CustomerModel) => {
      this.customer = list;
      this.found = true;
      console.log(this.customer);
    });
  }

  foreclouser() {
    this.service.requestForeclouser();
  }

}
