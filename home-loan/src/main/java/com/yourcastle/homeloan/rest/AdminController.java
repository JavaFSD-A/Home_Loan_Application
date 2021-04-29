/** 
 * @author raj
 */

package com.yourcastle.homeloan.rest;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import com.yourcastle.homeloan.service.AdminService;

@RestController
public class AdminController {
	
	@Autowired
	private AdminService service;
	
	@GetMapping(value = "/getCustomer/{cust_id}", produces = "application/json")
	public Customer getCustomerbyId(@PathVariable("cust_id") int cust_id) 
	{
		Customer customer=null;
		try {
			customer=service.getCustomerbyId(cust_id);
		} catch (CustomerNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}
		return customer;
	}
	
	@GetMapping(value = "/getCustomerAll", produces = "application/json")
	public List<Customer> getAllCustomers(){
		
		List<Customer> list=new ArrayList<Customer>();
		list=service.getAllCustomers();
		return list;
	}
	
	@PostMapping(value = "/updateStatus/{custId}")
	public ResponseEntity<?> updateLoanStatus(@PathVariable("custId") int cust_id, HttpSession session){
		boolean status;
		try {
			if (session.getAttribute("ADMIN") != null) {
			status = service.updatecustomerLoanStatus(cust_id);
			if(status == true) {
				return new ResponseEntity<String>("Accepted", HttpStatus.OK);
			}
			else {
			return new ResponseEntity<String>("Rejected", HttpStatus.OK);
		}   
			}
		return new ResponseEntity<String>("You are not logged in!", HttpStatus.OK);
			
			} catch (CustomerNotFoundException e) {
			// TODO Auto-generated catch block
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}
		
	}
	
	@PostMapping(value = "/auth", consumes = "application/json", produces = "application/json")
	  public ResponseEntity<?> authenticate(@RequestBody Login login, HttpSession session){
		    Admin admin = service.validate(login);
		    if(admin != null) {
		    	session.setAttribute("ADMIN", admin);
			    return new ResponseEntity<Admin>(admin, HttpStatus.OK);
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
