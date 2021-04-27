/** 
 * @author tarishi geetey, Anju, Satya
 */

package com.yourcastle.homeloan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yourcastle.homeloan.entity.AuthDocument;
import com.yourcastle.homeloan.entity.Capital;
import com.yourcastle.homeloan.entity.Customer;
import com.yourcastle.homeloan.entity.Loan;
import com.yourcastle.homeloan.exception.CapitalNotFoundException;
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
	public int addCustometer(Customer c) {
		custrepo.save(c);
		return c.getCust_id();
	}

	// Thinking about drawbacks of updating 
	@Override
	public boolean updateCustomer(Customer c, int cust_id) {
		Customer cust = custrepo.findById(cust_id).get();
		cust.setAdhar_no(c.getAdhar_no());
		cust.setCity(c.getCity());
		cust.setCust_address(c.getCust_address());
		cust.setCust_dob(c.getCust_dob());
		cust.setCust_email(c.getCust_email());
		cust.setCust_name(c.getCust_name());
		cust.setCust_passwd(c.getCust_passwd());
		cust.setPincode(c.getPincode());
		cust.setCust_phone_no(c.getCust_phone_no());
		return false;
	}

	@Override
	public int addAuthDocument(AuthDocument ad,  int cust_id) {  // change in code because I changed it is not map and oneTomany
		Customer cust = custrepo.findById(cust_id).get();
		cust.setCust_auth_document(ad);
		ad.setCustomer(cust);
		authrepo.save(ad);
		return ad.getAuth_id();
	
	}

	@Override
	public boolean updateAuthDocument(AuthDocument ad) {
		return false;
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
	public boolean updateCapital(Capital cap) {
		
		return false;
	}

	@Override
	public Capital getCapital(int capId) throws CapitalNotFoundException {
		return caprepo.findById(capId).orElseThrow(()-> new CapitalNotFoundException("Capital Not Found " +capId));

	}

	@Override
	public Customer getCustomer(int cust_id) throws CustomerNotFoundException {
		Customer cust = custrepo.findById(cust_id).orElseThrow(() -> new CustomerNotFoundException("No Customer found with Id : " + cust_id ));
		return cust;
	}

//	@Override
//	public int addLoan(Loan loan) {
//		
//	}

	
}
