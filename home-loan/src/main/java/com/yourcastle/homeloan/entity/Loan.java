/*
 * @author Vyshu
 */
package com.yourcastle.homeloan.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="loan")
public class Loan {
	@Id
	@GeneratedValue
	private int loan_id;
	@Column(length=50)
	private String loan_name;
	@Column(name="tenure")
	private int loan_tenure;
	private double loan_principal;
	private float loan_interest_rate;
	@Column(name="status",length=20)
	private String loan_status;
	private double loan_emi;
	
	@OneToOne
	@JoinColumn(name="cust_id")
	private Customer customer;

	public int getLoan_id() {
		return loan_id;
	}

	public void setLoan_id(int loan_id) {
		this.loan_id = loan_id;
	}

	public String getLoan_name() {
		return loan_name;
	}

	public void setLoan_name(String loan_name) {
		this.loan_name = loan_name;
	}

	public int getLoan_tenure() {
		return loan_tenure;
	}

	public void setLoan_tenure(int loan_tenure) {
		this.loan_tenure = loan_tenure;
	}

	public double getLoan_principal() {
		return loan_principal;
	}

	public void setLoan_principal(double loan_principal) {
		this.loan_principal = loan_principal;
	}

	public float getLoan_interest_rate() {
		return loan_interest_rate;
	}

	public void setLoan_interest_rate(float loan_interest_rate) {
		this.loan_interest_rate = loan_interest_rate;
	}

	public String getLoan_status() {
		return loan_status;
	}

	public void setLoan_status(String loan_status) {
		this.loan_status = loan_status;
	}

	public double getLoan_emi() {
		return loan_emi;
	}

	public void setLoan_emi(double loan_emi) {
		this.loan_emi = loan_emi;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
}