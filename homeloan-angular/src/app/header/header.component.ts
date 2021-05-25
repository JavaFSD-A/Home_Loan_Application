/**
  @author S Satya Sri,P Vyshnavi, Tarishi Geetey
*/
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CustomerService } from '../services/customer.service';
@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  navbarOpen = false;

  toggleNavbar() {
    this.navbarOpen = !this.navbarOpen;
  }

  constructor(private service : CustomerService, private route : Router) { }

  ngOnInit(): void {
  }

  logout(){
    this.service.logout();
    this.route.navigate(['login']);
  }
}
