/*
 * @author Vyshu
 */
package com.yourcastle.homeloan.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yourcastle.homeloan.entity.Loan;
import com.yourcastle.homeloan.service.LoanService;

@RestController
@RequestMapping("/loan")
public class LoanController {
	@Autowired
	private LoanService service;
	
	@PostMapping(value="/addLoan",consumes="application/json")
	public String addLoan(@RequestBody Loan loan) {
		int loanid = service.addLoan(loan);
		return "Loan added with id: " +loanid; 
	}

//	@PostMapping(value="/remove{lid}", consumes= "application/json")
//	public String removeLoan(@PathVariable("lid") int lid) {
//	   Loan l = service.removeLoan(lid);
//		return "Loan with id ;" +l+ "is removed";
//		
//	}
	@GetMapping(value="/get/{loanid}", produces="application/json")
	public String getLoan(@PathVariable ("loanid") int loanid) {
		service.getLoan(loanid);
		return "Loan with Id : " +loanid+ "is displayed";
	}

}
