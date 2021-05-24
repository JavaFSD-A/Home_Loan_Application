/*
 * @author Vyshnavi
 */
package com.yourcastle.homeloan.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yourcastle.homeloan.entity.Loan;

public interface LoanRepository extends JpaRepository<Loan,Integer>{

}
