/** 
 * @author tarishi geetey, Anju, Satya, Vyshu
 */

package com.yourcastle.homeloan.rest;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
import com.yourcastle.homeloan.exception.DocumentNotFoundException;
import com.yourcastle.homeloan.service.CustomerService;

@CrossOrigin
@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService service;

	/////////////////////////////////////// CUSTOMER /////////////////////////////////////// //////////////////////////////////////////////////

	@PostMapping(value = "/", consumes = "application/json")
	public ResponseEntity<?> addCustomer(@RequestBody Customer cust) {
		int custId;
		try {
			custId = service.addCustomer(cust);
			return new ResponseEntity<String>("New Customer added with Customer ID " + custId, HttpStatus.OK);
		} catch (CustomerAlreadyExists e) {
			throw new ResponseStatusException(HttpStatus.ALREADY_REPORTED, e.getMessage());
		}
	}

	@GetMapping(value = "/get/{cust_id}", produces = "application/json")
	public ResponseEntity<?> getCustomer(@PathVariable(value = "cust_id") int cust_id, HttpSession session) {
		Customer cust = null;
		try {
			cust = service.getCustomer(cust_id);
			return new ResponseEntity<Customer>(cust, HttpStatus.OK);
		} catch (CustomerNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}
	}

	@GetMapping(value = "/applyForceclousre/{cust_id}", produces = "application/json")
	public ResponseEntity<?> addForeclouser(@PathVariable("cust_id") int cust_id, HttpSession session) {
		try {
			if(service.foreclousreRequest(cust_id, 1) == true)
				return new ResponseEntity<String>("Requested Forceclousre", HttpStatus.OK);
			return new ResponseEntity<String>("No Loan Assigned Can't Request", HttpStatus.OK);
		} catch (CustomerNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}
	}

	///////////////////////////////////// AUTHDOCUMENT ///////////////////////////////////// ////////////////////////////////////////////////////

	@PostMapping(value = "/addAuthDocument/{custId}", consumes = "application/json")
	public ResponseEntity<?> addAuthDocument(@RequestBody AuthDocument ath, @PathVariable int custId,
			HttpSession session) {
		int authId;

		authId = service.addAuthDocument(ath, custId);
		return new ResponseEntity<String>("New Document added with Customer ID " + authId, HttpStatus.OK);

	}

	@GetMapping(value = "/getAuthDocument/{auth_id}", produces = "application/json")
	public ResponseEntity<?> getAuthDocument(@PathVariable("auth_id") int auth_id, HttpSession session) {
		AuthDocument ad = null;

		try {
			ad = service.getAllAuthDocument(auth_id);
			return new ResponseEntity<AuthDocument>(ad, HttpStatus.OK);

		} catch (DocumentNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}
	}

	///////////////////////////////////////// CAPITAL ///////////////////////////////////////// //////////////////////////////////////////////////////

	@PostMapping(value = "/addCapital/{custId}", consumes = "application/json")
	public ResponseEntity<?> addCapital(@RequestBody Capital cap, @PathVariable int custId, HttpSession session) {
		int capId;
		capId = service.addCapital(cap, custId);
		return new ResponseEntity<String>("New Capital document added with Customer ID " + capId, HttpStatus.OK);
	}

	@GetMapping(value = "/getCapital/{cust_id}", produces = "application/json")
	public ResponseEntity<?> getAllCapital(@PathVariable("cust_id") int cust_id, HttpSession session)
			throws CapitalNotFoundException {
		Capital cap = null;
		cap = service.getCapital(cust_id);
		return new ResponseEntity<Capital>(cap, HttpStatus.OK);

	}

	///////////////////////////////// LOAN ///////////////////////////////// //////////////////////////////////////////////////////////

	@PostMapping(value = "/addLoan/{cust_id}", consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> addLoan(@RequestBody Loan loan, @PathVariable int cust_id, HttpSession session) {
		int loanId;
		loanId = service.addLoan(loan, cust_id);
		return new ResponseEntity<>("New Loan added with with CustomerId: " + loanId, HttpStatus.OK);

	}

	@GetMapping(value = "/getLoan/{cust_id}", produces = "application/json")
	public ResponseEntity<?> getLoan(@PathVariable("cust_id") int cust_id, HttpSession session) {
		return new ResponseEntity<Loan>(service.getLoan(cust_id), HttpStatus.OK);
	}

	////////////////////////////////// LOGIN/LOGOUT ////////////////////////////////// //////////////////////////////////////////////////////////

	@PostMapping(value = "/auth", consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> authenticate(@RequestBody Login login, HttpSession session) {
		Customer customer = service.validate(login);
		if (customer != null) {
			// System.out.println("ok");
			session.setAttribute("CUSTOMER", customer);
			System.out.println(session.getAttribute("CUSTOMER"));
			return new ResponseEntity<Customer>(customer, HttpStatus.OK);
		} else
			return new ResponseEntity<String>("Invalid User or Pasword", HttpStatus.NOT_FOUND);
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "Logout successfull";
	}

}
