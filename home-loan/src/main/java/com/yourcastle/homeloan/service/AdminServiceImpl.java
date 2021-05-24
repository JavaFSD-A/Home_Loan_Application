/*
   @author Rajarshi, Tarishi Geetey
 */
package com.yourcastle.homeloan.service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yourcastle.homeloan.bean.Login;
import com.yourcastle.homeloan.entity.Admin;
import com.yourcastle.homeloan.entity.Customer;
import com.yourcastle.homeloan.entity.Loan;
import com.yourcastle.homeloan.exception.CustomerNotFoundException;
import com.yourcastle.homeloan.exception.NotAppliedForLoan;
import com.yourcastle.homeloan.repo.AdminRepository;
import com.yourcastle.homeloan.repo.CustomerRepository;


@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminRepository adminrepo;

	@Autowired
	private CustomerRepository cusrepo;



	@Override
	public Customer getCustomerbyId(int cust_id) throws CustomerNotFoundException {
		Customer c = cusrepo.findById(cust_id)
				.orElseThrow(() -> new CustomerNotFoundException("No Customer found with Customer ID : " + cust_id));
		return c;
	}

	@Override
	public List<Customer> getAllCustomers() {
		return cusrepo.findAll();
	}

	@Override
	public boolean updatecustomerLoanStatus(int cust_id) throws CustomerNotFoundException {
		Customer c = cusrepo.findById(cust_id).get();
		Loan l = c.getCust_loan();
		int age = Period.between(c.getCust_dob(), LocalDate.now()).getYears();
		if (l.getLoan_tenure() <= 30 && c.getCust_capital().getMonthly_income() >= 25000 && age >= 21 && age <= 62 && l.getLoan_principal() <= l.getLoan_emi() )
			return true;
		else
			return false;
	}

	@Override
	public Admin validate(Login login) {
		return adminrepo.findByPhoneNoAndPasswd(login.getPhone_no(), login.getLogin_passwd());
	}

	@Override
	public String foreclouserResponse(int cust_id) throws NotAppliedForLoan {
		Customer c = cusrepo.findById(cust_id).get();
		Loan l = c.getCust_loan();
		if (l.getLoan_status().equals("Accepted") && c.getForeclousre().equals("Requested")) {
				l.setLoan_status("Foreclosure Accepted");
				c.setForeclousre("Foreclosure Accepted");
				cusrepo.save(c);
				
			// Assuming 5 year loan has been covered 
			return String.format("%.2f",(((l.getLoan_principal() * ((l.getLoan_tenure()-5)/12) * (l.getLoan_interest_rate()/12))/100)));
			
		}
		throw new NotAppliedForLoan("No Loan exists under the customer ID : " + cust_id);
	}

	@Override
	public String acceptLoanRequest(int cust_id) throws CustomerNotFoundException {
		Customer c = cusrepo.findById(cust_id)
				.orElseThrow(() -> new CustomerNotFoundException("No Customer found with Customer ID : " + cust_id));
		Loan l = c.getCust_loan();
		l.setLoan_status("Accepted");
		cusrepo.save(c);
		String email = c.getCust_email();
		return email;
	}

	@Override
	public String rejecectLoanRequest(int cust_id) throws CustomerNotFoundException {
		Customer c = cusrepo.findById(cust_id)
				.orElseThrow(() -> new CustomerNotFoundException("No Customer found with Customer ID : " + cust_id));
		c.getCust_loan().setLoan_status("Rejected");
		cusrepo.save(c);
		String email = c.getCust_email();
		return email;
	}

}
