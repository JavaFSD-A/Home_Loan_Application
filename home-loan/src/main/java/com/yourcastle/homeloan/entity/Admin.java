/*
   @author raj
 */
package com.yourcastle.homeloan.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;
@Entity
@Table(name="admin_table")
public class Admin {
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idseq")
	private int admin_id;
	@Column(length = 30)
	private String adminName;
	@Column(length=15)
	private String adminPassword;
	@Column
	private boolean admin_permission;
	
	@JsonManagedReference
	@OneToMany(mappedBy ="admin", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Customer> cust_details=new ArrayList<Customer>();
	
	public Admin() {
		// TODO Auto-generated constructor stub
	}

	public Admin(int admin_id, String adminName, String adminPassword, boolean admin_permission,
			List<Customer> customer) {
		super();
		this.admin_id = admin_id;
		this.adminName = adminName;
		this.adminPassword = adminPassword;
		this.admin_permission = admin_permission;
		this.cust_details = customer;
	}

	public List<Customer> getCustomer() {
		return cust_details;
	}
	public void setCustomer(List<Customer> customer) {
		this.cust_details = customer;
	}
	public int getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(int admin_id) {
		this.admin_id = admin_id;
	}
	
	public boolean isAdmin_permission() {
		return admin_permission;
	}
	public void setAdmin_permission(boolean admin_permission) {
		this.admin_permission = admin_permission;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	public List<Customer> getCust_details() {
		return cust_details;
	}

	public void setCust_details(List<Customer> cust_details) {
		this.cust_details = cust_details;
	}
	
	
	
	
	

}
