/*
   @author Rajarshi, Tarishi Geetey
 */
package com.yourcastle.homeloan.repo;


import org.springframework.data.jpa.repository.JpaRepository;

import com.yourcastle.homeloan.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer> {
	
	
	Admin findByPhoneNoAndPasswd(String phoneNo, String passwd);
	
}
