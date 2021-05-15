/*
   @author raj
 */
package com.yourcastle.homeloan.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yourcastle.homeloan.entity.Admin;
import com.yourcastle.homeloan.entity.Customer;
import com.yourcastle.homeloan.entity.Loan;

public interface AdminRepository extends JpaRepository<Admin, Integer> {
	
	Admin findByEmailAndPasswd(String email, String adminPassword);
	Admin findByPhoneNoAndPasswd(String phoneNo, String passwd);
	Admin findByPhoneNo(String phoneNo);
}
