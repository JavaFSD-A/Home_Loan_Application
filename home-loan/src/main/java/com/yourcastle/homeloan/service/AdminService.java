/*
   @author raj
 */
package com.yourcastle.homeloan.service;

import java.util.List;

import com.yourcastle.homeloan.bean.Login;
import com.yourcastle.homeloan.entity.Admin;
import com.yourcastle.homeloan.entity.Customer;
import com.yourcastle.homeloan.exception.CustomerNotFoundException;

public interface AdminService {
	
	public Customer getCustomerbyId(int cust_id) throws CustomerNotFoundException;
	
	public List<Customer> getAllCustomers();
	
	public boolean updatecustomerLoanStatus(int cust_id) throws CustomerNotFoundException;

	public Admin validate(Login login);
	
	public int addAdmin(Admin admin);
	
}
