/** 
 * @author Tarishi Geetey
 */

package com.yourcastle.homeloan.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yourcastle.homeloan.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

	Customer findByPhoneNoAndPasswd(String phoneNo, String passwd);
	Customer findByPhoneNo(String phoneNo);
  
}

