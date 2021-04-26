/*
   @author satya
 */
package com.yourcastle.homeloan.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "capital")
public class Capital {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idseq")
	
	private int cap_id;
	@Column(length = 20)
	private String property_name;
	@Column(length = 20)
	private String location;
	private double property_value;
	private double monthly_income;
	
	@JsonBackReference
	@OneToOne
	@JoinColumn(name = "cust_id")
	private Customer customer;

	public int getCap_id() {
		return cap_id;
	}

	public void setCap_id(int cap_id) {
		this.cap_id = cap_id;
	}


	public String getProperty_name() {
		return property_name;
	}

	public void setProperty_name(String property_name) {
		this.property_name = property_name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public double getProperty_value() {
		return property_value;
	}

	public void setProperty_value(double property_value) {
		this.property_value = property_value;
	}

	public double getMonthly_income() {
		return monthly_income;
	}

	public void setMonthly_income(double monthly_income) {
		this.monthly_income = monthly_income;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
}
