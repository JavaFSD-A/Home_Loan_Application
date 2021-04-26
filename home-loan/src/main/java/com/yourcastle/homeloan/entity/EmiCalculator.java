package com.yourcastle.homeloan.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class EmiCalculator {

	@Id
	private int emi_id;
	private double intrest_rate;
	private int tenure;
	private double principle_amt;
	private double remaning_loan_amt;
	private int num_instalment;
	private double emi_to_pay;
	
	
	
	
}
