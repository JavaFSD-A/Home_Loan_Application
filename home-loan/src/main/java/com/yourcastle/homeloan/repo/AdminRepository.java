/*
   @author raj
 */
package com.yourcastle.homeloan.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yourcastle.homeloan.entity.Admin;
import com.yourcastle.homeloan.entity.Loan;

public interface AdminRepository extends JpaRepository<Admin, Integer> {
	
	Admin findByAdminNameAndAdminPassword(String adminName, String adminPassword);
}
