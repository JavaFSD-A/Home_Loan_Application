/**
* 
* 
*@author Anju 
* 
*/

package com.yourcastle.homeloan.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class AuthDocument {

	@Id
	@GeneratedValue
	private int auth_id;
	@Column(length = 50)
	private String auth_aadhar;
	@Column(length = 50)
	private String auth_pan;
	@Column(length = 50)
	private String auth_income_certificate;
	
	@ManyToOne
	@JoinColumn(name = "cust_id")
	private Customer customer;

	public int getAuth_id() {
		return auth_id;
	}

	public void setAuth_id(int auth_id) {
		this.auth_id = auth_id;
	}

	
	public String getAuth_aadhar() {
		return auth_aadhar;
	}

	public void setAuth_aadhar(String auth_aadhar) {
		this.auth_aadhar = auth_aadhar;
	}

	
	public String getAuth_pan() {
		return auth_pan;
	}
	
	public void setAuth_pan(String auth_pan) {
		this.auth_pan = auth_pan;
	}

	
	public String getAuth_income_certificate() {
		return auth_income_certificate;
	}
	
	public void setAuth_income_certificate(String auth_income_certificate) {
		this.auth_income_certificate = auth_income_certificate;
	}

	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
}