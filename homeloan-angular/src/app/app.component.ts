import { Component } from '@angular/core';
import { CustomerModel } from './customer.model';
import { CustomerService } from './services/customer.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'homeloan';

  constructor(private service : CustomerService){
  }
  ngOnInit(): void {
  }

  logout(){
    this.service.logout();
  }
}
