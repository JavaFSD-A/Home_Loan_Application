import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthdocModel } from '../models/authdoc.model';
import { CustomerService } from '../services/customer.service';

@Component({
  selector: 'app-authdoclist',
  templateUrl: './authdoclist.component.html',
  styleUrls: ['./authdoclist.component.css']
})
export class AuthdoclistComponent implements OnInit {
  authdoc: AuthdocModel;
  found: boolean;

  constructor(private service : CustomerService, private route : Router) { }

  ngOnInit(): void {
  }

  getDocumentById() {
    this.service
      .findDocumentById()
      .then((result : AuthdocModel)=> {
        this.authdoc = result;
        this.found = true;
        console.log(this.authdoc);
      });
  }
}
