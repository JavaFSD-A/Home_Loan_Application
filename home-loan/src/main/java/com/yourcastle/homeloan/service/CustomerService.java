/** 
 * @author Tarishi Geetey,S SatyaSri,P Vyshnavi
 */

package com.yourcastle.homeloan.service;

import com.yourcastle.homeloan.bean.Login;
import com.yourcastle.homeloan.entity.AuthDocument;
import com.yourcastle.homeloan.entity.Capital;
import com.yourcastle.homeloan.entity.Customer;
import com.yourcastle.homeloan.entity.Loan;
import com.yourcastle.homeloan.exception.CapitalNotFoundException;
import com.yourcastle.homeloan.exception.CustomerAlreadyExists;
import com.yourcastle.homeloan.exception.CustomerNotFoundException;


public interface CustomerService {

	Customer addCustomer(Customer c) throws CustomerAlreadyExists;

	Customer getCustomer(int cust_id) throws CustomerNotFoundException;
	
	int addAuthDocument(AuthDocument ad,  int cust_id);
	
	AuthDocument getAllAuthDocument(int cust_id) throws CustomerNotFoundException;
	
	int addCapital(Capital cap,  int cust_id);
	
	Capital getCapital(int capId) throws CapitalNotFoundException;
	
	int addLoan(Loan loan,  int cust_id);
	
	Loan getLoan(int cust_id);
	
    Customer validate(Login login);
    
	boolean foreclousreRequest(int cust_id, int flag);

	
}
