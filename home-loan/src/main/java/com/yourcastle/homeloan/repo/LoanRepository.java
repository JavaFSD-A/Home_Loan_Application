/*
 * @author Vyshu
 */
package com.ibm.loan.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ibm.loan.entity.Loan;

public interface LoanRepository extends JpaRepository<Loan,Integer>{

}
