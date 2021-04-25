/** 
 * @author tarishi geetey
 */

package com.yourcastle.homeloan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yourcastle.homeloan.entity.AuthDocument;
import com.yourcastle.homeloan.entity.Capital;
import com.yourcastle.homeloan.entity.Customer;
import com.yourcastle.homeloan.entity.Loan;
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

	@Override
	public boolean updateCustomer(Customer c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int addAuthDocument(AuthDocument ad,  int cust_id) {
		return cust_id;
	}

	@Override
	public boolean updateAuthDocument(AuthDocument ad) {
		return false;
	}

	@Override
	public AuthDocument getAllAuthDocument() {
		return null;
	}

	@Override
	public int addCapital(Capital cap,  int cust_id) {
		Customer customer=custrepo.findById(cust_id).get();
		customer.setCust_capital(cap);
		caprepo.save(cap);
		return cap.getCap_id();
	
	}

	@Override
	public boolean updateCapital(Capital cap) {
		
		return false;
	}

	@Override
	public Capital getCapital(int capId) {
		return caprepo.findById(capId).get();

	}

//	@Override
//	public int addLoan(Loan loan) {
//		
//	}

	
}
