/** 
 * @author tarishi geetey, Anju, Satya
 */

package com.yourcastle.homeloan.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;

import com.yourcastle.homeloan.bean.Login;
import com.yourcastle.homeloan.entity.AuthDocument;
import com.yourcastle.homeloan.entity.Capital;
import com.yourcastle.homeloan.entity.Customer;
import com.yourcastle.homeloan.entity.Loan;
import com.yourcastle.homeloan.exception.CapitalNotFoundException;
import com.yourcastle.homeloan.exception.CustomerAlreadyExists;
import com.yourcastle.homeloan.exception.CustomerNotFoundException;
import com.yourcastle.homeloan.exception.DocumentNotFoundException;
import com.yourcastle.homeloan.repo.AuthDocumentRepository;
import com.yourcastle.homeloan.repo.CapitalRepository;
import com.yourcastle.homeloan.repo.CustomerRepository;
import com.yourcastle.homeloan.repo.LoanRepository;


@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerRepository custrepo;
	
	@Autowired
    private CapitalRepository caprepo;
    
	@Autowired
    private AuthDocumentRepository authrepo;
    
	@Autowired
    private LoanRepository loanrepo;

	@Override
	public int addCustomer(Customer c){
		    
			custrepo.save(c);
		    return c.getCust_id();
		
	}


	@Override
	public int addAuthDocument(AuthDocument ad,  int cust_id) {  
		Customer cust = custrepo.findById(cust_id).get();
		cust.setCust_auth_document(ad);
		ad.setCustomer(cust);
		authrepo.save(ad);
		return ad.getAuth_id();
	
	}


	@Override
	public AuthDocument getAllAuthDocument(int auth_id) throws DocumentNotFoundException {
		AuthDocument ad =  authrepo.findById(auth_id).orElseThrow(() -> new DocumentNotFoundException("Document Not Found: "+ auth_id));
		return ad;
	}

	@Override
	public int addCapital(Capital cap,  int cust_id) {
		Customer customer=custrepo.findById(cust_id).get();
		customer.setCust_capital(cap);
		cap.setCustomer(customer);
		caprepo.save(cap);
		return cap.getCap_id();
	
	}

	@Override
	public Customer getCustomer(int cust_id) throws CustomerNotFoundException {
		Customer cust = custrepo.findById(cust_id).orElseThrow(() -> new CustomerNotFoundException("No Customer found with Id : " + cust_id ));
		return cust;
	}
	
	@Override
	public Capital getCapital(int capId) throws CapitalNotFoundException {
		return caprepo.findById(capId).orElseThrow(()-> new CapitalNotFoundException("Capital Not Found " +capId));

	}


	@Override
	public int addLoan(Loan loan, int cust_id) {
		Customer customer = custrepo.findById(cust_id).get();
		customer.setCust_loan(loan);
		loan.setCustomer(customer);
		loanrepo.save(loan);
		return loan.getLoan_id();
	}

	@Override
	public Loan getLoan(int loan_id) {
		return loanrepo.findById(loan_id).get();
	}


	@Override
	public List<Customer> getAllCustomers() {
		return custrepo.findAll();
	}


	@Override
	public Customer getByPhoneNo(String phoneNo) {
		return custrepo.findByPhoneNo(phoneNo);
	}


	@Override
	public boolean foreclousreRequest(int cust_id, int flag) {
		Customer customer = custrepo.findById(cust_id).get();
		if(flag == 1) {
			customer.setForeclousre(flag);
		    return true;
		}
		return false;
	}


	@Override
	public Customer validate(Login login) {
		// TODO Auto-generated method stub
		return  custrepo.findByPhoneNoAndPasswd(login.getPhone_no(), login.getLogin_passwd());
	}

	
}

















