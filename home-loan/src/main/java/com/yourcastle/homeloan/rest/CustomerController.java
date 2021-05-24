/** 
 * @author Tarishi Geetey, Anju, Satya, Vyshu
 */

package com.yourcastle.homeloan.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.yourcastle.homeloan.bean.Login;
import com.yourcastle.homeloan.entity.AuthDocument;
import com.yourcastle.homeloan.entity.Capital;
import com.yourcastle.homeloan.entity.Customer;
import com.yourcastle.homeloan.entity.Loan;
import com.yourcastle.homeloan.exception.CapitalNotFoundException;
import com.yourcastle.homeloan.exception.CustomerAlreadyExists;
import com.yourcastle.homeloan.exception.CustomerNotFoundException;
import com.yourcastle.homeloan.service.CustomerService;

@CrossOrigin
@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService service;

	/////////////////////////////////////// CUSTOMER /////////////////////////////////////////////////////////////////////////////////////////

	@PostMapping(value = "/", consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> addCustomer(@RequestBody Customer cust) {
		try {
			Customer customer= service.addCustomer(cust);
			return new ResponseEntity<Customer>(customer, HttpStatus.OK);
		} catch (CustomerAlreadyExists e) {
			return new ResponseEntity<String>("Wrong Credentials , try again!!", HttpStatus.OK);
		}
	}

	@GetMapping(value = "/get/{cust_id}", produces = "application/json")
	public ResponseEntity<?> getCustomer(@PathVariable(value = "cust_id") int cust_id) {
		Customer cust = null;
		try {
			cust = service.getCustomer(cust_id);
			return new ResponseEntity<Customer>(cust, HttpStatus.OK);
		} catch (CustomerNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}
	}

	@GetMapping(value = "/applyForceclousre/{cust_id}")
	public ResponseEntity<?> addForeclouser(@PathVariable("cust_id") int cust_id) {
		
			try {
				if(service.foreclousreRequest(cust_id, 1) == true) {
					return new ResponseEntity<String>("Requested Forceclousre", HttpStatus.OK);
			}
			return new ResponseEntity<String>("No Loan Assigned Can't Request/ Tenure is less than 5 years /Request already Submitted!!", HttpStatus.OK);
		
			} catch (CustomerNotFoundException e) {
				// TODO Auto-generated catch block
				return new ResponseEntity<String>("No Loan Assigned Can't Request/ Tenure is less than 5 years /Request already Submitted!!", HttpStatus.OK);
			}
	}

	///////////////////////////////////// AUTHDOCUMENT /////////////////////////////////////////////////////////////////////////////////////////

	@PostMapping(value = "/addAuthDocument/{custId}", consumes = "application/json")
	public ResponseEntity<?> addAuthDocument(@RequestBody AuthDocument ath, @PathVariable int custId) {
		int authId;
		authId = service.addAuthDocument(ath, custId);
		return new ResponseEntity<String>("New Document added with Customer ID " + authId, HttpStatus.OK);

	}

	@GetMapping(value = "/getAuthDocument/{cust_id}", produces = "application/json")
	public ResponseEntity<?> getAuthDocument(@PathVariable("cust_id") int cust_id) {
		

		try {
			AuthDocument ad = null;
			ad = service.getAllAuthDocument(cust_id);
			return new ResponseEntity<AuthDocument>(ad, HttpStatus.OK);

		} catch (CustomerNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}
	}

	///////////////////////////////////////// PROPERTY AND INCOME //////////////////////////////////////////////////////////////

	@PostMapping(value = "/addCapital/{custId}", consumes = "application/json")
	public ResponseEntity<?> addCapital(@RequestBody Capital cap, @PathVariable int custId) {
		int capId;
		capId = service.addCapital(cap, custId);
		return new ResponseEntity<String>("New Capital document added with Customer ID " + capId, HttpStatus.OK);
	}

	@GetMapping(value = "/getCapital/{cust_id}", produces = "application/json")
	public ResponseEntity<?> getAllCapital(@PathVariable("cust_id") int cust_id)
			throws CapitalNotFoundException {
		Capital cap = null;
		cap = service.getCapital(cust_id);
		return new ResponseEntity<Capital>(cap, HttpStatus.OK);

	}

	///////////////////////////////// LOAN /////////////////////////////////////////////////////////////////////

	@PostMapping(value = "/addLoan/{cust_id}", consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> addLoan(@RequestBody Loan loan, @PathVariable int cust_id) {
		int loanId;
		loanId = service.addLoan(loan, cust_id);
		return new ResponseEntity<String>("New Loan added with with CustomerId: " + loanId, HttpStatus.OK);

	}

	@GetMapping(value = "/getLoan/{cust_id}", produces = "application/json")
	public ResponseEntity<?> getLoan(@PathVariable("cust_id") int cust_id) {
		return new ResponseEntity<Loan>(service.getLoan(cust_id), HttpStatus.OK);
	}

	////////////////////////////////////// LOGIN/LOGOUT ///////////////////////////////////////////////////////

	@PostMapping(value = "/auth", consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> authenticate(@RequestBody Login login) {
		Customer customer = service.validate(login);
		if (customer != null) {
			return new ResponseEntity<Customer>(customer, HttpStatus.OK);
		} else
			return new ResponseEntity<String>("Invalid User or Pasword", HttpStatus.OK);
	}

	@GetMapping("/logout")
	public String logout() {
		return "Logout successfull";
	}

}
