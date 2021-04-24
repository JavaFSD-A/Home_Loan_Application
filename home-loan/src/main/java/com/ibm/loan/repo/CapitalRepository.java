/**
 * @author satya
 */
package com.ibm.loan.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ibm.loan.entity.Capital;


public interface CapitalRepository extends JpaRepository<Capital, Integer> {

}
