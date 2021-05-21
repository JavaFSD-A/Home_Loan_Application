import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AdminService } from '../services/admin.service';

@Component({
  selector: 'app-admindashbord',
  templateUrl: './admindashbord.component.html',
  styleUrls: ['./admindashbord.component.css']
})
export class AdmindashbordComponent implements OnInit {

  constructor(private service : AdminService, private route : Router) {
  }

  ngOnInit(): void {
    if(localStorage.getItem("admin") == null)
    this.route.navigate(['login']);
  }

  logout(){
    this.service.logout();
  }

}
