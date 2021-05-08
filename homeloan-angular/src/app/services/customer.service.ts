import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { CustomerModel } from '../customer.model';
import { delay, retry, catchError } from 'rxjs/operators';
import { throwError } from 'rxjs';
import { CustomerComponent } from '../customer/customer.component';
@Injectable({
  providedIn: 'root',
})
export class CustomerService {
  private customer: CustomerModel;

  private baseUri: string = 'http://localhost:8880/customer';

  constructor(private http: HttpClient, private route: Router) {}



  /**
   * 
   * @param phoneNo 
   * @param passwd 
   * @description Validate user
   * @returns post request url 
   */

  async authenticationService(phoneNo: string, passwd: string) {
    return await this.http
      .post<CustomerModel>(
        this.baseUri + "/auth",{"phone_no" : phoneNo, "login_passwd" : passwd}
      )
      .pipe(delay(100), catchError(this.handleError))
      .toPromise();
  }
  /**
   * @param customer 
   * @abstract Adds new customer
   */

  createCustomer(customer : CustomerModel){
    this.http.post(this.baseUri + "/", customer).subscribe(data => data = this.customer);
  }

/**
 * @descriptionHandleing Error Handler
 * @param error 
 * @returns error message
 * @throws error
 */

 logout() {
  localStorage.removeItem("user");
  this.route.navigate(['login']);
  this.http.get(this.baseUri + "/logout")
}

  handleError(error) {
    let errorMessage = '';
    if (error.error instanceof ErrorEvent) {
      // client-side error
      errorMessage = `Error: ${error.error.message}`;
    } else {
      // server-side error
      errorMessage = `Error Code: ${error.status}\nMessage: ${error.message}`;
    }
    window.alert(errorMessage);
    return throwError(errorMessage);
  }
}
