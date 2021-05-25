/**
 * @author D Anju
 * @description Auth Doc Save Form 
 */

import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthdocModel } from '../models/authdoc.model';
import { CustomerService } from '../services/customer.service';

@Component({
  selector: 'app-authdoc',
  templateUrl: './authdoc.component.html',
  styleUrls: ['./authdoc.component.css']
})
export class AuthdocComponent implements OnInit {
  authdoc : AuthdocModel;

  constructor(private service : CustomerService, private route : Router) {
    this.authdoc = new AuthdocModel();
   }

  ngOnInit(): void {
  }

  addDocument(){
    this.service.createDocument(this.authdoc);
    alert("Thank You For Choosing Our Servises!!.. Login To continue...");
    this.route.navigate(['login']);
  }
}
