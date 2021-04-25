/**
 * @author tarishi geetey
 * Eligiblity criteria considered : 
 * age Limit : 23-62
 * min_sal : 25000
 * max_tenure : 30
 */

package com.yourcastle.homeloan.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class EligibilityCalculator {

	@Id
	@GeneratedValue
	private int elig_id;
	private int age;
	private double income_per_mth;
	private int tenure_yr;
	private double  roi;  // return on investment
	private boolean eligiblity;
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getIncome_per_mth() {
		return income_per_mth;
	}
	public void setIncome_per_mth(double income_per_mth) {
		this.income_per_mth = income_per_mth;
	}
	public int getTenure_yr() {
		return tenure_yr;
	}
	public void setTenure_yr(int tenure_yr) {
		this.tenure_yr = tenure_yr;
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
