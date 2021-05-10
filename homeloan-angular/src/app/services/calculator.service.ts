import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { CalculatorModel } from '../calculator.model';
import { delay } from "rxjs/operators";
@Injectable({
  providedIn: 'root'
})
export class CalculatorService {

  private baseUri: string = 'http://localhost:8880/calculator';
  constructor(private http: HttpClient, private route: Router) {}

  async eligiblityCheck(calculator : CalculatorModel) {
    
    return await this.http
      .post<CalculatorModel>(this.baseUri + '/eligiblityCheck', calculator);
  }
}
