package com.yourcastle.homeloan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yourcastle.homeloan.entity.Customer;
import com.yourcastle.homeloan.entity.Login;
import com.yourcastle.homeloan.repo.CustomerRepository;
import com.yourcastle.homeloan.repo.LoginRepository;

@Service
public class LoginServiceImpl implements LoginService{

	@Autowired
	private LoginRepository loginrepo;
	
	@Autowired 
	private CustomerRepository custrepo;

	@Override
	public Login authenticationUser(Login login, String role) {
		if(role.equals("customer")) {
			List<Customer> customer = custrepo.findAll();
			for(int i=0; i<customer.size(); i++) {
				if(login.getPhone_no() == customer.get(i).getCust_phone_no() && login.getLogin_passwd().equals(customer.get(i).getCust_passwd()))
					return login;
			}
			
		}
			return null;
	}
	
	

}
