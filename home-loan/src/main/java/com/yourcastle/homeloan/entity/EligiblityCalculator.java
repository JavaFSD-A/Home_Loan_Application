package com.yourcastle.homeloan.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class EligiblityCalculator {
	
	@Id
	private int e_id;
	private int age;
	private int tenure_yr;
	private double income_per_mth;
	private double roi;
	private boolean eligiblity;
	
	public EligiblityCalculator() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public EligiblityCalculator(int e_id, int age, int tenure_yr, double income_per_mth, double roi,
			boolean eligiblity) {
		super();
		this.e_id = e_id;
		this.age = age;
		this.tenure_yr = tenure_yr;
		this.income_per_mth = income_per_mth;
		this.roi = roi;
		this.eligiblity = eligiblity;
	}



	public int getE_id() {
		return e_id;
	}
	public void setE_id(int e_id) {
		this.e_id = e_id;
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
