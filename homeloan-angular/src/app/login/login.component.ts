import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AdminModel } from '../admin.model';
import { CustomerModel } from '../models/customer.model';
import { LoginModel } from '../models/login.model';
import { AdminService } from '../services/admin.service';
import { CustomerService } from '../services/customer.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  auth : LoginModel;
  constructor(private service : CustomerService, private aservice : AdminService, private router : Router) {
    this.auth = new LoginModel();
   }

  ngOnInit(): void {
  }

  authentication(){
     
  let customer : CustomerModel;
  
    this.service.authenticationService(this.auth.phone_no, this.auth.login_passwd).then((result : CustomerModel) => {
       customer = result;
  
    if(customer != null){
      console.log("Logged in");
       localStorage.setItem("customer", JSON.stringify(customer));
       this.router.navigate(['home']);
      }else{
     alert("Login Failed");
      }
    });
  }

  adminAuthentication(){
     
    let admin : AdminModel;
    
      this.aservice.adminAuthenticationService(this.auth.phone_no, this.auth.login_passwd).then((result : AdminModel) => {
         admin = result;
    
      if(admin != null){
        console.log("Logged in");
         localStorage.setItem("admin", JSON.stringify(admin));
         this.router.navigate(['admindashbord']);
        }else{
       alert("Login Failed");
        }
      });
    }
  

}
