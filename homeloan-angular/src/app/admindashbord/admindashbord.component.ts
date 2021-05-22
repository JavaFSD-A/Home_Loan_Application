import { Component, OnInit, ViewChild } from '@angular/core';
import { Router } from '@angular/router';
import { AdminService } from '../services/admin.service';
import { MatSidenav } from '@angular/material/sidenav';
@Component({
  selector: 'app-admindashbord',
  templateUrl: './admindashbord.component.html',
  styleUrls: ['./admindashbord.component.css']
})
export class AdmindashbordComponent implements OnInit {

  constructor(private service : AdminService, private route : Router) {
  }


  @ViewChild('sidenav') sidenav: MatSidenav;
  isExpanded = true;
  showSubmenu: boolean = false;
  isShowing = false;
  showSubSubMenu: boolean = false;

  mouseenter() {
    if (!this.isExpanded) {
      this.isShowing = true;
    }
  }

  mouseleave() {
    if (!this.isExpanded) {
      this.isShowing = false;
    }
  }

  showCustomers(){
    this.route.navigate(['admindashbord/admin']);
  }

  showAllCustomers(){
    this.route.navigate(['admindashbord/search']);
  }

  
  ngOnInit(): void {
    if(localStorage.getItem("admin") == null)
    this.route.navigate(['login']);
  }

  logout(){
    this.service.logout();
    this.route.navigate(['login']);
  }

}
