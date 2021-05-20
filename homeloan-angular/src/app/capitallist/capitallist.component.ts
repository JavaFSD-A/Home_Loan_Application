import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CapitalModel } from '../models/capital.model';
import { CustomerService } from '../services/customer.service';

@Component({
  selector: 'app-capitallist',
  templateUrl: './capitallist.component.html',
  styleUrls: ['./capitallist.component.css']
})
export class CapitallistComponent implements OnInit {

  capital : CapitalModel;
  found : boolean;
   constructor(private service : CustomerService, private route : Router) { }
 
   ngOnInit(): void {
   }
 
   getCapitalById() {
     this.service
       .findCapitalById()
       .then((result : CapitalModel)=> {
         this.capital = result;
         this.found = true;
         console.log(this.capital);
       });

       
   }
}
