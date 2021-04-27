package com.yourcastle.homeloan.bean;

import javax.persistence.Entity;
import javax.persistence.Id;

public class EmiCalculator {


	private double intrest_rate;
	private int tenure;
	private double principle_amt;
	private double remaning_loan_amt;
	private int num_instalment;
	private double emi_to_pay;
	
	public EmiCalculator() {
		// TODO Auto-generated constructor stub
	}


	public double getIntrest_rate() {
		return intrest_rate;
	}

	public void setIntrest_rate(double intrest_rate) {
		this.intrest_rate = intrest_rate;
	}

	public int getTenure() {
		return tenure;
	}

	public void setTenure(int tenure) {
		this.tenure = tenure;
	}

	public double getPrinciple_amt() {
		return principle_amt;
	}

	public void setPrinciple_amt(double principle_amt) {
		this.principle_amt = principle_amt;
	}

	public double getRemaning_loan_amt() {
		return remaning_loan_amt;
	}

	public void setRemaning_loan_amt(double remaning_loan_amt) {
		this.remaning_loan_amt = remaning_loan_amt;
	}

	public int getNum_instalment() {
		return num_instalment;
	}

	public void setNum_instalment(int num_instalment) {
		this.num_instalment = num_instalment;
	}

	public double getEmi_to_pay() {
		return emi_to_pay;
	}

	public void setEmi_to_pay(double emi_to_pay) {
		this.emi_to_pay = emi_to_pay;
	}
	
	
	
	
}
