/*
@author  Tarishi G.
*/
import { AuthdocModel } from "./authdoc.model";
import { CapitalModel } from "./capital.model";
import { LoanModel } from "./loan.model";


export class CustomerModel{
    cust_id : number;
    custName : string;
    cust_dob : Date;
    cust_email : string;
    phoneNo : string;
    passwd : number;
    cust_gender : string;
    cust_address : string;
    city : string;
    state : string;
    pincode : number;
    adharno : number; 
    foreclousre : "Not Applied";
    cust_loan : LoanModel;
    cust_capital : CapitalModel;
    cust_auth_document : AuthdocModel;
}