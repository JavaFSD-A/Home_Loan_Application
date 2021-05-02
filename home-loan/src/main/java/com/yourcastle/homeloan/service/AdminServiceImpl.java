/*
   @author raj
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
import com.yourcastle.homeloan.repo.LoanRepository;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminRepository adminrepo;

	@Autowired
	private CustomerRepository cusrepo;

	@Autowired
	private LoanRepository loanrepo;

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
		if (l.getLoan_tenure() <= 30 && c.getCust_capital().getMonthly_income() >= 25000 && age >= 23 && age <= 62)
			return true;
		else
			return false;
	}

	@Override
	public Admin validate(Login login) {
		login.setRole("ADMIN");
		return adminrepo.findByEmailAndAdminPassword(login.getEmail(), login.getLogin_passwd());
	}

	@Override
	public int addAdmin(Admin admin) {
		adminrepo.save(admin);
		return admin.getAdmin_id();
	}

	@Override
	public double foreclouserResponse(int cust_id, int flag, String bal_principal, String months_left) throws NotAppliedForLoan {
		Customer c = cusrepo.findById(cust_id).get();
		Loan l = c.getCust_loan();
		if (l != null) {
			if (flag == 1) {
				l.setLoan_status("Foreclosure");
				return (Double.parseDouble(bal_principal) * Integer.parseInt(months_left) * l.getLoan_interest_rate());
			}
			return 0;
		}
		throw new NotAppliedForLoan("No Loan exists under the customer ID : " + cust_id);
	}

	@Override
	public void acceptLoanRequest(int cust_id) throws CustomerNotFoundException {
		Customer c = cusrepo.findById(cust_id)
				.orElseThrow(() -> new CustomerNotFoundException("No Customer found with Customer ID : " + cust_id));
		;
		c.getCust_loan().setLoan_status("Accepted");
	}

	@Override
	public void rejecectLoanRequest(int cust_id) throws CustomerNotFoundException {
		Customer c = cusrepo.findById(cust_id)
				.orElseThrow(() -> new CustomerNotFoundException("No Customer found with Customer ID : " + cust_id));
		;
		c.getCust_loan().setLoan_status("Rejected");
	}

}
