/*
   @author raj
 */
package com.yourcastle.homeloan.service;

import java.util.List;

import com.yourcastle.homeloan.entity.Customer;
import com.yourcastle.homeloan.exception.CustomerNotFoundException;

public interface AdminService {
	
	public boolean approveLoan(int loanId);

	public boolean rejectLoan(int loanId);
	
	public Customer getCustomerbyId(int cust_id) throws CustomerNotFoundException;
	
	public List<Customer> getAllCustomers();
	
	public boolean updatecustomerLoanStatus(int cust_id);

}
