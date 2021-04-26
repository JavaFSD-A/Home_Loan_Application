/*
 * @author Vyshu
 */
package com.yourcastle.homeloan.service;

import com.yourcastle.homeloan.entity.Customer;
import com.yourcastle.homeloan.entity.Loan;

public interface LoanService {
	
int addLoan(Loan l);
	
	//Loan removeLoan(int loan_id);
	
	Loan getLoan(int loan_id);
	
	String getStatusByCustomerId(Customer cust_id);

}
