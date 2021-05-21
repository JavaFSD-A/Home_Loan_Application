package com.yourcastle.homeloan.bean;

import javax.persistence.Entity;
import javax.persistence.Id;

public class EligiblityCalculator {
	
	private int age;
	private int tenure_yr;
	private double income_per_mth;
	private double roi;
	private String eligiblity;
	private double calculatedMaxVal = 0;
	
	public EligiblityCalculator() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public EligiblityCalculator(int age, int tenure_yr, double income_per_mth, double roi, String eligiblity,
			double calculatedMaxVal) {
		super();
		this.age = age;
		this.tenure_yr = tenure_yr;
		this.income_per_mth = income_per_mth;
		this.roi = roi;
		this.eligiblity = eligiblity;
		this.calculatedMaxVal = calculatedMaxVal;
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

	public String getEligiblity() {
		return eligiblity;
	}


	public void setEligiblity(String eligiblity) {
		this.eligiblity = eligiblity;
	}


	public double getCalculatedMaxVal() {
		return calculatedMaxVal;
	}

	public void setCalculatedMaxVal(double calculatedMaxVal) {
		this.calculatedMaxVal = calculatedMaxVal;
	}
	
	

}
