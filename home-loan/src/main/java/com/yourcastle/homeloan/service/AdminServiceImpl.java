/*
   @author raj
 */
package com.yourcastle.homeloan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yourcastle.homeloan.entity.Customer;
import com.yourcastle.homeloan.exception.CustomerNotFoundException;
import com.yourcastle.homeloan.repo.AdminRepository;
import com.yourcastle.homeloan.repo.CustomerRepository;

@Service
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	private AdminRepository adminrepo;
	
	@Autowired
	private CustomerRepository cusrepo;

	@Override
	public boolean approveLoan(int loanId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean rejectLoan(int loanId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Customer getCustomerbyId(int cust_id) throws CustomerNotFoundException{
		Customer c= cusrepo.findById(cust_id).orElseThrow(()-> new CustomerNotFoundException("No Customer found with Customer ID : "+ cust_id));
		return c;
	}

	@Override
	public List<Customer> getAllCustomers() {
		return cusrepo.findAll();
	}

	@Override
	public boolean updatecustomerLoanStatus(int cust_id) {
		
		return false;
	}
	

}
