import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AdminComponent } from './admin/admin.component';
import { AdmindashbordComponent } from './admindashbord/admindashbord.component';
import { CalculatorComponent } from './calculator/calculator.component';
import { CapitaldetailsComponent } from './capitaldetails/capitaldetails.component';
import { CapitallistComponent } from './capitallist/capitallist.component';
import { CustomerComponent } from './customer/customer.component';
import { CustomerlistComponent } from './customerlist/customerlist.component';
import { FormgroupComponent } from './formgroup/formgroup.component';
import { HomeComponent } from './home/home.component';
import { LoanComponent } from './loan/loan.component';
import { LoanlistComponent } from './loanlist/loanlist.component';
import { LoginComponent } from './login/login.component';

const routes: Routes = [
  {path: '', component: LoginComponent},
  {path: 'login', component: LoginComponent},
  {path: 'home', component: HomeComponent},
  {path: 'customer', component: CustomerComponent},
  {path: 'customerlist', component: CustomerlistComponent},
  {path: 'loan', component: LoanComponent},
  {path: 'loanlist', component: LoanlistComponent},
  {path: 'capital', component: CapitaldetailsComponent},
  {path: 'capitallist', component: CapitallistComponent},
  {path: 'admin', component: AdminComponent},
  {path: 'formgroup', component: FormgroupComponent},
  {path: 'admindashbord', component: AdmindashbordComponent},
  {path: 'calculator', component: CalculatorComponent},
  {path: '**', redirectTo: '/customer', pathMatch: 'full'}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
