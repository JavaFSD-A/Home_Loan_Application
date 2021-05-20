import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { delay, retry, catchError } from 'rxjs/operators';
import { Observable, throwError } from 'rxjs';
import { AdminModel } from '../admin.model';
import { CustomerModel } from '../models/customer.model';

@Injectable({
  providedIn: 'root'
})
export class AdminService {

  private admin : AdminModel;
  private baseUri: string = 'http://localhost:8880';

  constructor(private http: HttpClient, private route: Router) { }


  /**
   * Post  /auth 
   * @description Admin Authentication
   * @param phoneNo 
   * @param passwd 
   * @returns 
   */
  async adminAuthenticationService(phoneNo: string, passwd: string) {

    return await this.http
      .post<AdminModel>(this.baseUri + '/auth', {
        phone_no: phoneNo,
        login_passwd: passwd
      })
      .pipe(retry(1), catchError(this.handleError))
      .toPromise();
  }

   /**
   * GET /getCustomerBy/{cust_id}
   * @param id
   * @returns
   * @description display customer details by his/her id
   */

    async customerById(cust_id : number) {
      return await this.http
        .get<CustomerModel>(this.baseUri + '/getCustomer/' + cust_id)
        .pipe(delay(1000), catchError(this.handleError))
        .toPromise();
    }

    /**
   * GET /getCustomerAll
   * @param
   * @returns
   * @description display collection of customer
   */

     async allCustomer() {
      return await this.http
        .get<CustomerModel[]>(this.baseUri + '/getCustomerAll')
        .pipe(delay(1000), catchError(this.handleError))
        .toPromise();
    }

     /**
   * Post /updateLoanstatus/{cust_id}
   * @param
   * @returns
   * @description display collection of customer
   */

      async updateStatus(cust_id : number) {
        return await this.http
          .get(this.baseUri + '/updateStatus/' + cust_id)
          .pipe(delay(1000), catchError(this.handleError))
          .toPromise();
      }
   /**
   *  GET /logout
   * @description Logout call
   */

    logout() {
      localStorage.removeItem('admin');
      this.route.navigate(['login']);
      this.http.get(this.baseUri + '/logout');
    }

   /**
   * @descriptionHandleing Error Handler
   * @param error
   * @returns error message
   * @throws error
   */

    handleError(error) {
      let errorMessage = '';
      if (error.error instanceof ErrorEvent) {
        // client-side error
        errorMessage = `Error: ${error.error.message}`;
      } else {
        // server-side error
        errorMessage = `Error Code: ${error.status}\nMessage: ${error.error.text}`;
      }
      window.alert(errorMessage);
      return throwError(errorMessage);
    }
}
