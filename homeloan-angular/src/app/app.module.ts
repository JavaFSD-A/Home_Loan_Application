import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { CustomerComponent } from './customer/customer.component';
import { LoginComponent } from './login/login.component';
import { CustomerlistComponent } from './customerlist/customerlist.component';
import { LoanComponent } from './loan/loan.component';
import { LoanlistComponent } from './loanlist/loanlist.component';
import { CapitaldetailsComponent } from './capitaldetails/capitaldetails.component';
import { CapitallistComponent } from './capitallist/capitallist.component';
import { CalculatorComponent } from './calculator/calculator.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MaterialModule } from "./material/material.module"
@NgModule({
  declarations: [
    AppComponent,
    CustomerComponent,
    LoginComponent,
    CustomerlistComponent,
    LoanComponent,
    LoanlistComponent,
    CapitaldetailsComponent,
    CapitallistComponent,
    CalculatorComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MaterialModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
