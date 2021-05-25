/** 
 * @author Tarishi Geetey,D Anju,S SatyaSri,P Vyshnavi
 */

package com.yourcastle.homeloan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.yourcastle.homeloan.bean.Login;
import com.yourcastle.homeloan.entity.AuthDocument;
import com.yourcastle.homeloan.entity.Capital;
import com.yourcastle.homeloan.entity.Customer;
import com.yourcastle.homeloan.entity.Loan;
import com.yourcastle.homeloan.exception.CapitalNotFoundException;

import com.yourcastle.homeloan.exception.CustomerNotFoundException;
import com.yourcastle.homeloan.repo.AuthDocumentRepository;
import com.yourcastle.homeloan.repo.CapitalRepository;
import com.yourcastle.homeloan.repo.CustomerRepository;
import com.yourcastle.homeloan.repo.LoanRepository;


@Service
public class CustomerServiceImpl implements CustomerService{
	
	static final double FOIR = 0.5;
	
	@Autowired
	private CustomerRepository custrepo;
	
	@Autowired
    private CapitalRepository caprepo;
    
	@Autowired
    private AuthDocumentRepository authrepo;
    
	@Autowired
    private LoanRepository loanrepo;

	
	// Adding Customer Personal Details
	
	@Override
	public Customer addCustomer(Customer c){
		    Customer cust = new Customer();
			cust = custrepo.save(c);
		    return cust;
		
	}
	

	// Fetching All Customer Details by Customer_ID

	@Override
	public Customer getCustomer(int cust_id) throws CustomerNotFoundException {
		Customer cust = custrepo.findById(cust_id).orElseThrow(() -> new CustomerNotFoundException("No Customer found with Id : " + cust_id ));
		return cust;
	}
	
   
	// Adding Customer Document Details
	
	@Override
	public int addAuthDocument(AuthDocument ad,  int cust_id) {  
		Customer cust = custrepo.findById(cust_id).get();
		cust.setCust_auth_document(ad);
		ad.setCustomer(cust);
		authrepo.save(ad);
		return ad.getAuth_id();
	
	}

	// Fetching Document Details by Customer_ID

	@Override
	public AuthDocument getAllAuthDocument(int cust_id) throws CustomerNotFoundException {
		Customer customer =  custrepo.findById(cust_id).orElseThrow(() -> new CustomerNotFoundException("Customer Not Found: "+ cust_id));
		AuthDocument ad = customer.getCust_auth_document();
		return ad;
	}
	
	// Adding Customer Property and Income Details

	@Override
	public int addCapital(Capital cap,  int cust_id) {
		Customer customer=custrepo.findById(cust_id).get();
		customer.setCust_capital(cap);
		cap.setCustomer(customer);
		caprepo.save(cap);
		return cap.getCap_id();
	
	}
	
	
	// Fetching Property And Income Details by Customer_ID
	
	@Override
	public Capital getCapital(int cust_id) throws CapitalNotFoundException {
		Customer customer = custrepo.findById(cust_id).orElseThrow(()-> new CapitalNotFoundException("Capital Not Found at ID " + cust_id));;
		Capital capital = customer.getCust_capital();
		return capital;
	}

	
	// Adding Customer Loan Details

	@Override
	public int addLoan(Loan loan, int cust_id) {
		Customer customer = custrepo.findById(cust_id).get();
		customer.setCust_loan(loan);
		loan.setCustomer(customer);
		loan.setLoan_emi(customer.getCust_capital().getMonthly_income() * loan.getLoan_tenure() * 12 * FOIR);
		loan.setLoan_status("Applied");
		loanrepo.save(loan);
		return loan.getLoan_id();
	}

	// Fetching Loan Details by Customer_ID
	
	@Override
	public Loan getLoan(int cust_id) {
		Customer customer = custrepo.findById(cust_id).get();
		Loan loan = customer.getCust_loan();
		return loan;
	}

	// Requesting For Foreclosure

	@Override
	public boolean foreclousreRequest(int cust_id, int flag) {
		Customer customer = custrepo.findById(cust_id).get();
		if(flag == 1 && customer.getCust_loan().getLoan_status().equals("Accepted") && customer.getCust_loan().getLoan_tenure() > 5) {
			customer.setForeclousre("Requested");
			custrepo.save(customer);
		    return true;
		}
		return false;
	}

	// Validating Customer

	@Override
	public Customer validate(Login login) {
		// TODO Auto-generated method stub
		return  custrepo.findByPhoneNoAndPasswd(login.getPhone_no(), login.getLogin_passwd());
	}

	
}

















