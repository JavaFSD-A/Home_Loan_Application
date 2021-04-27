package com.yourcastle.homeloan.bean;

import javax.persistence.Entity;
import javax.persistence.Id;

public class EligiblityCalculator {
	
	private int age;
	private int tenure_yr;
	private double income_per_mth;
	private double roi;
	private boolean eligiblity;
	
	public EligiblityCalculator() {
		// TODO Auto-generated constructor stub
	}
	



	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getTenure_yr() {
		return tenure_yr;
	}
	public void setTenure_yr(int tenure_yr) {
		this.tenure_yr = tenure_yr;
	}
	public double getIncome_per_mth() {
		return income_per_mth;
	}
	public void setIncome_per_mth(double income_per_mth) {
		this.income_per_mth = income_per_mth;
	}
	public double getRoi() {
		return roi;
	}
	public void setRoi(double roi) {
		this.roi = roi;
	}
	public boolean isEligiblity() {
		return eligiblity;
	}
	public void setEligiblity(boolean eligiblity) {
		this.eligiblity = eligiblity;
	}
	
	

}
