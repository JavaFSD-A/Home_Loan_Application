/** 
 * @author tarishi geetey
 */

package com.yourcastle.homeloan.service;

import java.util.Collection;
import java.util.List;

import com.yourcastle.homeloan.entity.AuthDocument;
import com.yourcastle.homeloan.entity.Capital;
import com.yourcastle.homeloan.entity.Customer;
import com.yourcastle.homeloan.entity.Loan;
import com.yourcastle.homeloan.exception.CustomerNotFoundException;
import com.yourcastle.homeloan.exception.DocumentNotFoundException;

public interface CustomerService {

	int addCustometer(Customer c);
	boolean updateCustomer(Customer c, int cust_id);
	Customer getCustomer(int cust_id) throws CustomerNotFoundException;
	
	int addAuthDocument(AuthDocument ad,  int cust_id);
	boolean updateAuthDocument(AuthDocument ad);
	AuthDocument getAllAuthDocument(int auth_id) throws DocumentNotFoundException;
	
	int addCapital(Capital cap,  int cust_id);
	boolean updateCapital(Capital cap);
	Capital getCapital(int capId);
	
	int addLoan(Loan loan,  int cust_id);
	Loan getLoan(int loan_id);
	
	
}
