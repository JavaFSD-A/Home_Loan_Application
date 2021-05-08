import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CustomerModel } from '../customer.model';
import { CustomerlistComponent } from '../customerlist/customerlist.component';
import { LoginModel } from '../login.model';
import { CustomerService } from '../services/customer.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  auth : LoginModel;

  constructor(private service : CustomerService, private router : Router) {
    this.auth = new LoginModel();
   }

  ngOnInit(): void {
  }

  authentication(){
     
  let customer : CustomerModel;
  
    this.service.authenticationService(this.auth.phone_no, this.auth.login_passwd).then((result : CustomerModel) => {
       customer = result;
  
    if(customer != null){
       localStorage.setItem("customer", JSON.stringify(customer));
       this.router.navigate(['customerlist']);
     }else
     alert("Login Failed");
    });
  }
}
