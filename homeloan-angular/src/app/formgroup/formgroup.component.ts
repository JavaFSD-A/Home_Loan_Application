import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CustomerService } from '../services/customer.service';

@Component({
  selector: 'app-formgroup',
  templateUrl: './formgroup.component.html',
  styleUrls: ['./formgroup.component.css']
})
export class FormgroupComponent implements OnInit {

  constructor(
    private service: CustomerService,
    private route: Router
  ) {}


  ngOnInit(): void {
  }

  submit(){
    this.route.navigate(['login']);
    alert("Your Details are Saved!! Login to continue");

  }

}
