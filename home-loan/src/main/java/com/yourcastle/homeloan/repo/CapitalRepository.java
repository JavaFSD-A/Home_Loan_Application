/*
  @author S SatyaSri
 */
package com.yourcastle.homeloan.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yourcastle.homeloan.entity.Capital;


public interface CapitalRepository extends JpaRepository<Capital, Integer> {

}
