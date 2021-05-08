/** 
 * @author tarishi geetey
 */
package com.yourcastle.homeloan.entity;


import java.time.LocalDate;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "customers")
public class Customer {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idseq")
	@Column(name = "customer_id")
	private int cust_id;
	@Column(length =  30)
	private String custName;
	private LocalDate cust_dob;
	@Column(length = 25)
	private String cust_email;
	@Column(name = "phone_no", length = 10, unique = true)
	private String phoneNo;
	@Column(length = 20)
	private String passwd;
	@Column(length = 15)         // respecting gender fluidity
	private String cust_gender;
	@Column(length = 40)
	private String cust_address;
	@Column(length = 15)
	private String state;
	@Column(length = 15)
	private String city;
	@Column(length = 6)
	private int pincode;
	@Column(length = 12)
	private Long  adhar_no;
	private int foreclousre = 0;
	
	@JsonManagedReference
	@OneToOne(mappedBy = "customer", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Loan cust_loan;
    
	@JsonManagedReference
	@OneToOne(mappedBy = "customer", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Capital cust_capital;
	
	@JsonManagedReference   // corrected
	@OneToOne(mappedBy = "customer", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private AuthDocument cust_auth_document;
	
	@JsonBackReference
	@OneToOne
	@JoinColumn(name = "admin_id")
	private Admin admin;
	
	public Customer() {
	
	}


	public Customer(int cust_id, String custName, LocalDate cust_dob, String cust_email, String phoneNo, String passwd,
			String cust_gender, String cust_address, String state, String city, int pincode, Long adhar_no,
			int foreclousre, Loan cust_loan, Capital cust_capital, AuthDocument cust_auth_document, Admin admin) {
		super();
		this.cust_id = cust_id;
		this.custName = custName;
		this.cust_dob = cust_dob;
		this.cust_email = cust_email;
		this.phoneNo = phoneNo;
		this.passwd = passwd;
		this.cust_gender = cust_gender;
		this.cust_address = cust_address;
		this.state = state;
		this.city = city;
		this.pincode = pincode;
		this.adhar_no = adhar_no;
		this.foreclousre = foreclousre;
		this.cust_loan = cust_loan;
		this.cust_capital = cust_capital;
		this.cust_auth_document = cust_auth_document;
		this.admin = admin;
	}





	public String getState() {
		return state;
	}





	public void setState(String state) {
		this.state = state;
	}





	public int getCust_id() {
		return cust_id;
	}

	public void setCust_id(int cust_id) {
		this.cust_id = cust_id;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public LocalDate getCust_dob() {
		return cust_dob;
	}

	public void setCust_dob(LocalDate cust_dob) {
		this.cust_dob = cust_dob;
	}

	public String getCust_email() {
		return cust_email;
	}

	public void setCust_email(String cust_email) {
		this.cust_email = cust_email;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
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




	public Admin getAdmin() {
		return admin;
	}


	public void setAdmin(Admin admin) {
		this.admin = admin;
	}



	public int getForeclousre() {
		return foreclousre;
	}



	public void setForeclousre(int foreclousre) {
		this.foreclousre = foreclousre;
	}
	
	
	
}
