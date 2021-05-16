import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { CalculatorModel } from '../models/eligiblityCal.model';
import { delay, retry, catchError } from 'rxjs/operators';
import { Observable, throwError } from 'rxjs';
import { EmiCalculatorModel } from '../models/emiCal.model';
@Injectable({
  providedIn: 'root'
})
export class CalculatorService {

  private baseUri: string = 'http://localhost:8880/calculator';
  constructor(private http: HttpClient, private route: Router) {}

  /**
   * Post /calculator/eligiblityCheck
   * @param calculator 
   * @returns JSON of EligiblityCalculatorModel -- updated maxloan and eligiblity status
   */
  async eligiblityCheck(calculator : CalculatorModel) {
    
    return await this.http
      .post<CalculatorModel>(this.baseUri + '/eligiblityCheck', calculator)
      .pipe(retry(1))
      .toPromise();
  }

   /**
    *  Post /calculator/fixedEmi
    * @description Calculating fixed emi
    * @param emiCalModel 
    * @returns  
    */
    async fixedEmi(emiCal : EmiCalculatorModel) {
    
      return await this.http
        .post<EmiCalculatorModel>(this.baseUri + '/fixedEmi', emiCal)
        .pipe(retry(1))
        .toPromise();
    }

    /**
    *  Post /calculator/fixedEmi
    * @description Calculating fixed emi
    * @param emiCalModel 
    * @returns  
    */
     async reducingEmi(emiCal : EmiCalculatorModel) {
    
      return await this.http
        .post<EmiCalculatorModel>(this.baseUri + '/reducingEmi', emiCal)
        .pipe(retry(1))
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
