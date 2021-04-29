/*
   @author raj
 */
package com.yourcastle.homeloan.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yourcastle.homeloan.bean.Login;
import com.yourcastle.homeloan.entity.Admin;
import com.yourcastle.homeloan.entity.Customer;
import com.yourcastle.homeloan.entity.Loan;
import com.yourcastle.homeloan.exception.CustomerNotFoundException;
import com.yourcastle.homeloan.repo.AdminRepository;
import com.yourcastle.homeloan.repo.CustomerRepository;
import com.yourcastle.homeloan.repo.LoanRepository;

@Service
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	private AdminRepository adminrepo;
	
	@Autowired
	private CustomerRepository cusrepo;
	
	@Autowired
	private LoanRepository loanrepo;

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
	public boolean updatecustomerLoanStatus(int cust_id) throws CustomerNotFoundException {
		Customer c= cusrepo.findById(cust_id).orElseThrow(()-> new CustomerNotFoundException("No Customer found with Customer ID : "+ cust_id));
		Loan l=c.getCust_loan();
		long age=ChronoUnit.YEARS.between(LocalDate.now(), (Temporal) c.getCust_dob());
		if((l.getLoan_tenure()==20||l.getLoan_tenure()==30) && c.getCust_capital().getMonthly_income()>=25000 && age>=23 && age <=62)
			return true;
		else
		   return false;
	}

	@Override
	public Admin validate(Login login) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
