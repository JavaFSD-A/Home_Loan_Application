/** 
 * @author raj
 */

package com.yourcastle.homeloan.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.yourcastle.homeloan.entity.Mail;
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
	
	@PostMapping(value = "/addAdmin", consumes = "application/json") // not required
	public String addAdmin(@RequestBody Admin admin) {
		int aid = service.addAdmin(admin);
		return "successfully added";
	}
	
	//////////////////////// CUSTOMER ACCESS ///////////////////////////////////////
	
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
	
	//////////////////////////////// UPDATES AND PERMISSIONS /////////////////////////////////////////
	
	@GetMapping(value = "/updateStatus/{custId}")
	public ResponseEntity<?> updateLoanStatus(@PathVariable("custId") int cust_id, HttpSession session){
		boolean status;
		String email;
		try {
			status = service.updatecustomerLoanStatus(cust_id);
			if(status == true) {
				email = service.acceptLoanRequest(cust_id);
				mailservice.sendEmail(email,"Your Request is Accepted");
				return new ResponseEntity<String>("Accepted", HttpStatus.OK);
			}
			else {
				email = service.rejecectLoanRequest(cust_id);
				mailservice.sendEmail(email,"Sorry! Your Request is Rejected");
			return new ResponseEntity<String>("Rejected", HttpStatus.OK);
		}   
			} catch (CustomerNotFoundException e) {
			// TODO Auto-generated catch block
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}
		
	}
	
	@PostMapping(value = "/foreclousreResponse/{custId}/{flag}")
	public ResponseEntity<?> foreclousre(@RequestParam Map<String, String> map, @PathVariable("custId") int cust_id,  @PathVariable("flag") int flag, HttpSession session){
		double forclousre_amt;
		try {
			forclousre_amt = service.foreclouserResponse(cust_id, flag, map.get("bal_principal"), map.get("months_left"));
			if(forclousre_amt != 0) {
				return new ResponseEntity<String>("Accepted: Foreclouser Amount Need to pay : " + forclousre_amt, HttpStatus.OK);
			}
			else {
			return new ResponseEntity<String>("Pending", HttpStatus.OK);
		}   
			
			} catch (CustomerNotFoundException | NotAppliedForLoan e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}
		
	}
	
	
	////////////////////////////////// LOGIN //////////////////////////////////////////////////////
	
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
