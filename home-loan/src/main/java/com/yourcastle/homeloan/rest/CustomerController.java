/** 
 * @author tarishi geetey, Anju, Satya
 */

package com.yourcastle.homeloan.rest;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import com.yourcastle.homeloan.exception.CapitalNotFoundException;
import com.yourcastle.homeloan.exception.CustomerAlreadyExists;
import com.yourcastle.homeloan.exception.CustomerNotFoundException;
import com.yourcastle.homeloan.exception.DocumentNotFoundException;
import com.yourcastle.homeloan.service.CustomerService;


@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService service;
	
	
	@PostMapping(value = "/addCustomer", consumes = "application/json")
	public ResponseEntity<?> addCustomer(@RequestBody Customer cust) {
			int custId;
			try {
				custId = service.addCustomer(cust);
			} catch (CustomerAlreadyExists e) {
				throw new ResponseStatusException(HttpStatus.ALREADY_REPORTED,e.getMessage());
			}
			return new ResponseEntity<String>("New Customer added with Customer ID " + custId, HttpStatus.OK) ;			
	}
	
	@PostMapping(value = "/addAuthDocument/{custId}", consumes = "application/json")
	public String addAuthDocument(@RequestBody AuthDocument ath, @PathVariable int custId) {
		int authId = service.addAuthDocument(ath, custId);
		return "New Document added with Customer ID " + authId ;
		
	}
	
	@PostMapping(value = "/addCapital/{custId}", consumes = "application/json")
	public String addCapital(@RequestBody Capital cap, @PathVariable int custId) {
		int capId = service.addCapital(cap, custId);
		return "New Capital document added with Customer ID " + capId ;
		
	}
	
	@GetMapping(value = "/get/{cust_id}", produces = "application/json")
	public Customer getCustomer(@PathVariable("cust_id") int cust_id) {
		Customer cust = null;
		try {
			cust= service.getCustomer(cust_id);
		} catch (CustomerNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}
		return cust;
	}
	
	@GetMapping(value = "/getAuthDocument", produces = "application/json")
	public AuthDocument getAuthDocument(@PathVariable("auth_id") int auth_id) {
		AuthDocument ad = null;
		try {
			ad= service.getAllAuthDocument(auth_id);
		} catch (DocumentNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}
		return ad;
	}
	
	@GetMapping(value = "/getCapital/{capId}", produces = "application/json")
	public Capital getAllCapital(@PathVariable("capId") int capId) throws CapitalNotFoundException {
		Capital cap=null;
		cap=service.getCapital(capId);
		return cap;
	}
	
	@PostMapping(value = "/auth", consumes = "application/json", produces = "application/json")
	  public ResponseEntity<?> authenticate(@RequestBody Login login, HttpSession session){
		    Customer customer = service.validate(login);
		    if(customer != null) {
		    	session.setAttribute("CUSTOMER", customer);
			    return new ResponseEntity<Customer>(customer, HttpStatus.OK);
			}
		    else
		    	return new ResponseEntity<String>("Invalid User or Pasword", HttpStatus.NOT_FOUND);
		
		}
		
		@GetMapping("/logout")
		public String logout(HttpSession session) {
			session.invalidate(); //destroy session
			return "Logout successfull";
		}
	
	
}
