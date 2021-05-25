/** 
 * @author tarishi geetey
 */

package com.yourcastle.homeloan.service;

import java.util.List;


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
	//boolean updateCustomer(Customer c, int cust_id);
	Customer getCustomer(int cust_id) throws CustomerNotFoundException;
	
	int addAuthDocument(AuthDocument ad,  int cust_id);
	//boolean updateAuthDocument(AuthDocument ad);
	AuthDocument getAllAuthDocument(int cust_id) throws CustomerNotFoundException;
	
	int addCapital(Capital cap,  int cust_id);
	//boolean updateCapital(Capital cap);
	Capital getCapital(int capId) throws CapitalNotFoundException;
	
	int addLoan(Loan loan,  int cust_id);
	
	Loan getLoan(int cust_id);
	
    Customer validate(Login login);
    
	List<Customer> getAllCustomers();
	
	Customer getByPhoneNo(String phoneNo);
	
	boolean foreclousreRequest(int cust_id, int flag);

	
}
