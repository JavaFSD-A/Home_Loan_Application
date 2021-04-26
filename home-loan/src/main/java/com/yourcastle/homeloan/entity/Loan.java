/*
 * @author Vyshu
 */
package com.yourcastle.homeloan.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Loan {
	@Id
	private int loan_id;
	private int loan_tenure;
	private double loan_principal;
	private float loan_interest_rate;
	private String loan_status;
	private double loan_emi;

}
