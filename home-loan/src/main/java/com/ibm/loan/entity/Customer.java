package com.ibm.loan.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "myseq")
	@Column(name = "customer_id")
	private int cust_id;
	@Column(length = 30)
	private String cust_name;
	private Date cust_dob;
	private int cust_phone_no;
	private String cust_email;
	private String cust_passwd;
	private String cust_gender;
	private String city;
	private int pincode;
	private int adhar_no;
	
	Loan cust_loan;
	Capital cust_capital;
	//AuthDocument cust_auth_doc;
	
	
}
