import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { CustomerModel } from '../models/customer.model';
import { delay, retry, catchError } from 'rxjs/operators';
import { Observable, throwError } from 'rxjs';
import { LoanModel } from '../models/loan.model';
import { CapitalModel } from '../models/capital.model';
import { AuthdocModel } from '../models/authdoc.model';

@Injectable({
  providedIn: 'root',
})
export class CustomerService {
  private customer: CustomerModel;

  private baseUri: string = 'http://localhost:8880/customer';

  constructor(private http: HttpClient, private route: Router) {}

  /**
   * POST /customer/auth @RequestBody JSON
   * @param phoneNo
   * @param passwd
   * @description Validate user
   * @returns post request url
   */

  async authenticationService(phoneNo: string, passwd: string) {
    return await this.http
      .post<CustomerModel>(this.baseUri + '/auth', {
        phone_no: phoneNo,
        login_passwd: passwd,
      })
      .pipe(retry(1), catchError(this.handleError))
      .toPromise();
  }

  /**
   * POST /customer/
   * @param customer
   * @abstract Adds new customer
   */

  createCustomer(customer: CustomerModel) {
    this.http
      .post(this.baseUri + '/', customer)
      .subscribe((data) => (data = this.customer));
  }

  /**
   * GET /customer/get/{id}
   * @param id
   * @returns
   * @description display customer details by his/her id
   */

  async customerById() {
    let customer = JSON.parse(localStorage.getItem('customer'));
    return await this.http
      .get<CustomerModel>(this.baseUri + '/get/' + customer.cust_id)
      .pipe(delay(1000), catchError(this.handleError))
      .toPromise();
  }

  /**
   * @description Request Forclouser
   * @returns 
   */

  async requestForeclouser() {
    let customer = JSON.parse(localStorage.getItem('customer'));
    return this.http
      .get<CustomerModel>(
        this.baseUri + '/applyForceclousre/' + customer.cust_id
      )
      .pipe(delay(1000), catchError(this.handleError))
      .toPromise();
  }

  /**
   * POST /addloan/{cust_id}
   * @param loan
   * @returns
   */
  async createLoan(loan: LoanModel) {
    let customer: CustomerModel;
    customer = JSON.parse(localStorage.getItem('customer'));
    return await this.http
      .post(this.baseUri + '/addLoan/' + customer.cust_id, loan)
      .subscribe((data) => (data = loan));
  }

  /**
   * GET /getLoan/{cust_id}
   * @returns
   */

  async findLoanById() {
    let customer = JSON.parse(localStorage.getItem('customer'));
    return await this.http
      .get<LoanModel>(this.baseUri + '/getLoan/' + customer.cust_id)
      .pipe(retry(1), catchError(this.handleError))
      .toPromise();
  }

  /**
   * POST /addCapital/{cust_id}
   * @param capital
   * @returns
   */

  async createCapital(capital: CapitalModel) {
    let customer: CustomerModel;
    customer = JSON.parse(localStorage.getItem('customer'));
    return await this.http
      .post(this.baseUri + '/addCapital/' + customer.cust_id, capital)
      .subscribe((data) => (data = capital));
  }

  /**
   * GET /getCapital/{cust_id}
   * @returns 
   */

  async findCapitalById() {
    let customer = JSON.parse(localStorage.getItem('customer'));
    return await this.http
      .get<CapitalModel>(this.baseUri + '/getCapital/' + customer.cust_id)
      .pipe(retry(1), catchError(this.handleError))
      .toPromise();
  }

  /**
   * POST /addAuthDocument/{custId}
   * @param authdoc
   * @returns
   */

   async createDocument(authdoc: AuthdocModel) {
    let customer: CustomerModel;
    customer = JSON.parse(localStorage.getItem('customer'));
    return await this.http
      .post(this.baseUri + '/addAuthDocument/' + customer.cust_id, authdoc)
      .subscribe((data) => (data = authdoc));
  }

  /**
   * GET /getAuthDocument/{cust_id}
   * @returns 
   */

 async findDocumentById() {
  let customer = JSON.parse(localStorage.getItem('customer'));
  return await this.http
    .get<AuthdocModel>(this.baseUri + '/getAuthDocument/' + customer.cust_id)
    .pipe(retry(1), catchError(this.handleError))
    .toPromise();
}

  /**
   *  GET /customer/logout
   * @description Logout call
   */

  logout() {
    localStorage.removeItem('customer');
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