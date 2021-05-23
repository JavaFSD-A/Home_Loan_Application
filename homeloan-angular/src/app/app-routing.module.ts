import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AdminComponent } from './admin/admin.component';
import { AdmindashbordComponent } from './admindashbord/admindashbord.component';
import { AuthdocComponent } from './authdoc/authdoc.component';
import { AuthdoclistComponent } from './authdoclist/authdoclist.component';
import { CalculatorComponent } from './calculator/calculator.component';
import { CapitaldetailsComponent } from './capitaldetails/capitaldetails.component';
import { CapitallistComponent } from './capitallist/capitallist.component';
import { CustomerComponent } from './customer/customer.component';
import { CustomerlistComponent } from './customerlist/customerlist.component';
import { EligiblitycalComponent } from './eligiblitycal/eligiblitycal.component';
import { EmicalculatorComponent } from './emicalculator/emicalculator.component';
import { HomeComponent } from './home/home.component';
import { LoanComponent } from './loan/loan.component';
import { LoanlistComponent } from './loanlist/loanlist.component';
import { LoginComponent } from './login/login.component';
import { ProfileComponent } from './profile/profile.component';
import { SearchComponent } from './search/search.component';


const routes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'login', component: LoginComponent},
  {path: 'home', component: HomeComponent},

  {path: 'profile', component: ProfileComponent, children: [
    {path: 'customerlist', component: CustomerlistComponent},
    {path: 'loanlist', component: LoanlistComponent},
    {path: 'capitallist', component: CapitallistComponent},
    {path: 'authdoclist', component: AuthdoclistComponent}
  ]},
  
    {path: 'customer', component: CustomerComponent},
    {path: 'loan', component: LoanComponent},
    {path: 'capital', component: CapitaldetailsComponent},
    {path: 'authdoc', component: AuthdocComponent},

  {path: 'calculator', component: CalculatorComponent},
  {path: 'eligiblitycalculator', component: EligiblitycalComponent},
  {path: 'emicalculator', component: EmicalculatorComponent},

  {path: 'admindashbord', component: AdmindashbordComponent, children: [
    {path: 'search', component: SearchComponent},
    {path: 'admin', component: AdminComponent}
    ]},
    
  {path: '**', redirectTo: '/home', pathMatch: 'full'}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
