/** 
 * @author Rajarshi, Tarishi Geetey
 */

package com.yourcastle.homeloan.rest;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;


import com.yourcastle.homeloan.bean.Login;
import com.yourcastle.homeloan.entity.Admin;
import com.yourcastle.homeloan.entity.Customer;
import com.yourcastle.homeloan.exception.CustomerNotFoundException;
import com.yourcastle.homeloan.exception.NotAppliedForLoan;
import com.yourcastle.homeloan.service.AdminService;
import com.yourcastle.homeloan.service.MailServiceImpl;

@CrossOrigin
@RestController
public class AdminController {
	
	@Autowired
	private AdminService service;
	
	@Autowired 
	private MailServiceImpl mailservice;
	
	////////////////////////////// ADMIN ///////////////////////////////////////////////////////////////////
	
	@PostMapping(value = "/addAdmin", consumes = "application/json") // not required
	public String addAdmin(@RequestBody Admin admin) {
		service.addAdmin(admin);
		return "successfully added";
	}
	
	///////////////////////////////////// CUSTOMER ACCESS //////////////////////////////////////////////////
	
	@GetMapping(value = "/getCustomer/{cust_id}", produces = "application/json")
	public ResponseEntity<?> getCustomerbyId(@PathVariable("cust_id") int cust_id) 
	{
		Customer customer=null;
		try {
			customer=service.getCustomerbyId(cust_id);
			if(customer != null)
				return new ResponseEntity<Customer>(customer, HttpStatus.OK);
			return new ResponseEntity<String>("No Cusrtomer found with ID: " + cust_id, HttpStatus.OK);
		} catch (CustomerNotFoundException e) {
			return new ResponseEntity<String>("No Cusrtomer found with ID: " + cust_id, HttpStatus.OK);
		}
		
	}
	
	@GetMapping(value = "/getCustomerAll", produces = "application/json")
	public List<Customer> getAllCustomers(){
		
		List<Customer> list=new ArrayList<Customer>();
		list=service.getAllCustomers();
		return list;
	}
	
	//////////////////////////////// UPDATES AND PERMISSIONS /////////////////////////////////////////
	
	@GetMapping(value = "/updateStatus/{custId}")
	public ResponseEntity<?> updateLoanStatus(@PathVariable("custId") int cust_id){
		boolean status;
		String email;
		try {
			status = service.updatecustomerLoanStatus(cust_id);
			if(status == true) {
				email = service.acceptLoanRequest(cust_id);
				mailservice.sendEmail(email,"Congratulations!! Your Loan is Approved.");
				return new ResponseEntity<String>("Accepted..Mail sent!!", HttpStatus.OK);
			}
			else {
				email = service.rejecectLoanRequest(cust_id);
				mailservice.sendEmail(email,"Sorry! Your Loan is Not Approved");
			return new ResponseEntity<String>("Rejected..Mail sent!!", HttpStatus.OK);
		}   
			} catch (CustomerNotFoundException e) {
			// TODO Auto-generated catch block
			throw new  ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}
		
	}
	
	@GetMapping(value = "/foreclousreResponse/{cust_id}")
	public ResponseEntity<?> foreclousre(@PathVariable("cust_id") int cust_id){
		String forclousre_amt = null;
		try {
			forclousre_amt = service.foreclouserResponse(cust_id);
			if(forclousre_amt != null) {
				return new ResponseEntity<String>("Accepted Foreclouser" + forclousre_amt, HttpStatus.OK);
			}
			else {
			return new ResponseEntity<String>("Pending", HttpStatus.OK);
		}   
			
			} catch (CustomerNotFoundException | NotAppliedForLoan e) {
				return new ResponseEntity<String>("Already Updated!! / Customer not applied for foreclousre", HttpStatus.OK);
		}
		
	}
	
	
	////////////////////////////////// LOGIN //////////////////////////////////////////////////////
	
	@PostMapping(value = "/auth", consumes = "application/json", produces = "application/json")
	  public ResponseEntity<?> authenticate(@RequestBody Login login){
		    Admin admin = service.validate(login);
		    if(admin != null) {
			    return new ResponseEntity<Admin>(admin, HttpStatus.OK);
			}
		    else
		    	return new ResponseEntity<String>("Invalid User or Pasword", HttpStatus.OK);
		
		}
		
		@GetMapping("/logout")
		public String logout() {
			return "Logout successfull";
		}
	
}
