import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CustomerModel } from '../models/customer.model';
import { CustomerService } from '../services/customer.service';

@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.css']
})
export class CustomerComponent implements OnInit {

  customer : CustomerModel;
  cust_gender : string[];

  constructor(private service : CustomerService, private route : Router) {
    this.customer = new CustomerModel();
    this.cust_gender = ["Male","Female","Rainbow","Prefer not to tell"];
   }

  ngOnInit(): void {
  }

  saveCustomer(){
    this.service.createCustomer(this.customer);
  }


}
