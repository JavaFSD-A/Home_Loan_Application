/** 
 * @author tarishi geetey
 */
package com.yourcastle.homeloan.entity;


import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "customers")
public class Customer {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idseq")
	@Column(name = "customer_id")
	private int cust_id;
	@Column(length =  30)
	private String cust_name;
	private Date cust_dob;
	@Column(length = 25)
	private String cust_email;
	@Column(name = "phone_no", length = 10, unique = true)
	private Long phoneNo;
	@Column(length = 20)
	private String passwd;
	@Column(length = 15)         // respecting gender fluidity
	private String cust_gender;
	@Column(length = 40)
	private String cust_address;
	@Column(length = 15)
	private String city;
	@Column(length = 6)
	private int pincode;
	@Column(length = 12)
	private Long  adhar_no;
	
	@OneToOne(mappedBy = "customer", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Loan cust_loan;
    
	@OneToOne(mappedBy = "customer", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Capital cust_capital;
	
	@JsonManagedReference   // corrected
	@OneToOne(mappedBy = "customer", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private AuthDocument cust_auth_document;
	
	public Customer() {
	
	}

	
	public Customer(int cust_id, String cust_name, Date cust_dob, String cust_email, Long phoneNo,
			String passwd, String cust_gender, String cust_address, String city, int pincode, Long adhar_no,
			Loan cust_loan, Capital cust_capital, AuthDocument cust_auth_document) {
		super();
		this.cust_id = cust_id;
		this.cust_name = cust_name;
		this.cust_dob = cust_dob;
		this.cust_email = cust_email;
		this.phoneNo = phoneNo;
		this.passwd = passwd;
		this.cust_gender = cust_gender;
		this.cust_address = cust_address;
		this.city = city;
		this.pincode = pincode;
		this.adhar_no = adhar_no;
		this.cust_loan = cust_loan;
		this.cust_capital = cust_capital;
		this.cust_auth_document = cust_auth_document;
	}


	public int getCust_id() {
		return cust_id;
	}

	public void setCust_id(int cust_id) {
		this.cust_id = cust_id;
	}

	public String getCust_name() {
		return cust_name;
	}

	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}

	public Date getCust_dob() {
		return cust_dob;
	}

	public void setCust_dob(Date cust_dob) {
		this.cust_dob = cust_dob;
	}

	public String getCust_email() {
		return cust_email;
	}

	public void setCust_email(String cust_email) {
		this.cust_email = cust_email;
	}

	public Long getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(Long phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getCust_passwd() {
		return passwd;
	}

	public void setCust_passwd(String passwd) {
		this.passwd = passwd;
	}

	public String getCust_gender() {
		return cust_gender;
	}

	public void setCust_gender(String cust_gender) {
		this.cust_gender = cust_gender;
	}

	public String getCust_address() {
		return cust_address;
	}

	public void setCust_address(String cust_address) {
		this.cust_address = cust_address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public Long getAdhar_no() {
		return adhar_no;
	}

	public void setAdhar_no(Long adhar_no) {
		this.adhar_no = adhar_no;
	}

	public Loan getCust_loan() {
		return cust_loan;
	}

	public void setCust_loan(Loan cust_loan) {
		this.cust_loan = cust_loan;
	}
	
	public Capital getCust_capital() {
		return cust_capital;
	}


	public void setCust_capital(Capital cust_capital) {
		this.cust_capital = cust_capital;
	}


	public AuthDocument getCust_auth_document() {
		return cust_auth_document;
	}


	public void setCust_auth_document(AuthDocument cust_auth_document) {
		this.cust_auth_document = cust_auth_document;
	}
	
	
	
}
