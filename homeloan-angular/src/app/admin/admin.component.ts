/**
 * @autor Tarishi G.
 */

import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CustomerModel } from '../models/customer.model';
import { AdminService } from '../services/admin.service';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

 customer : CustomerModel;
 customers : CustomerModel[] = [];
  constructor(private service : AdminService, private route : Router) {
  }

  ngOnInit(): void {
    if(localStorage.getItem("admin") == null)
    this.route.navigate(['login']);
   }

  getAllCustomer(){
    this.service.allCustomer().then((result: CustomerModel[])=>{
    this.customers=result;
    console.log(result);
    });
  }

  clouserResponse(cust_id : number){
    this.service.foreclouserResponse(cust_id);
    }

}
