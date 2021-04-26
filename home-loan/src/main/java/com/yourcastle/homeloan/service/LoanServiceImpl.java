/*
 * @author Vyshu
 */
package com.yourcastle.homeloan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yourcastle.homeloan.entity.Customer;
import com.yourcastle.homeloan.entity.Loan;
import com.yourcastle.homeloan.repo.LoanRepository;

@Service
public class LoanServiceImpl implements LoanService {

	@Autowired
	private LoanRepository loanrepo;
	
	@Override
	public int addLoan(Loan l) {
		loanrepo.save(l);
		return l.getLoan_id();    //sounds better if it returns loan name
	}

//	@Override
//	public Loan removeLoan(int loan_id) {
//		return loanrepo.deleteById(loan_id);
//	                //returning null
//   }
 
	@Override
	public String getStatusByCustomerId(Customer cust_id) {
		return null;
	}

	@Override
	public Loan getLoan(int loan_id) {
		Loan loan = loanrepo.findById(loan_id).get();
		return loan;
	}
}