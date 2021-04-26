/** 
 * @author raj
 */

package com.yourcastle.homeloan.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

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
	

}
