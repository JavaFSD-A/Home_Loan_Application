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
import com.yourcastle.homeloan.exception.CapitalNotFoundException;

public interface CustomerService {

	int addCustomer(Customer c);
	boolean updateCustomer(Customer c, int cust_id);
	Customer getCustomer(int cust_id) throws CustomerNotFoundException;
	
	int addAuthDocument(AuthDocument ad,  int cust_id);
	boolean updateAuthDocument(AuthDocument ad);
	AuthDocument getAllAuthDocument(int auth_id) throws DocumentNotFoundException;
	
	int addCapital(Capital cap,  int cust_id);
	boolean updateCapital(Capital cap);
	Capital getCapital(int capId) throws CapitalNotFoundException;
	//int addLoan(Loan loan,  int cust_id);
	//int updateCapital(Capital cap, int cust_id);
	
	
}
