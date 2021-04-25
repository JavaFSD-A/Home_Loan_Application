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
		Customer cust = custrepo.findById(cust_id).get();
	    cust.getCust_auth_document().add(ad);
	    ad.setCustomer(cust);
		authrepo.save(ad);
		return ad.getAuth_id();
	}

	@Override
	public boolean updateAuthDocument(AuthDocument ad) {
		return false;
	}

	@Override
	public List<AuthDocument> getAllAuthDocument() {
		return authrepo.findAll();
	}

	@Override
	public int addCapital(Capital cap,  int cust_id) {
		Customer cust = custrepo.findById(cust_id).get();
	    cust.setCust_capital(cap);
		caprepo.save(cap);
		return cap.getCap_id();
	}

	@Override
	public boolean updateCapital(Capital cap) {
		
		return false;
	}

	@Override
	public Capital getAllCapital(int capId) {
		Capital cap = caprepo.findById(capId).get();
		return cap;
	}

//	@Override
//	public int addLoan(Loan loan) {
//		loanrepo.save(loan);
//		return loan.get;
//	}

	
}
