import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { CalculatorModel } from '../calculator.model';
import { delay, retry, catchError } from 'rxjs/operators';
import { Observable, throwError } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class CalculatorService {

  private baseUri: string = 'http://localhost:8880/calculator';
  constructor(private http: HttpClient, private route: Router) {}

  /**
   * Post /calculator/eligiblityCheck
   * @param calculator 
   * @returns Eligiblity Check 
   */
  async eligiblityCheck(calculator : CalculatorModel) {
    
    return await this.http
      .post<CalculatorModel>(this.baseUri + '/eligiblityCheck', calculator)
      .pipe(retry(1), catchError(this.handleError))
      .toPromise();
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
