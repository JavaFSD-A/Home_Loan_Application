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
	private String admin_name;
	@Column(length=15)
	private String admin_password;
	@Column
	private boolean admin_permission;
	@JsonManagedReference
	@OneToMany (fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name="cust_id")
	private List<Customer> cust_details=new ArrayList<Customer>();
	
	public Admin() {
		// TODO Auto-generated constructor stub
	}

	public Admin(int admin_id, String admin_name, String admin_password, boolean admin_permission,
			List<Customer> customer) {
		super();
		this.admin_id = admin_id;
		this.admin_name = admin_name;
		this.admin_password = admin_password;
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
	public String getAdmin_name() {
		return admin_name;
	}
	public void setAdmin_name(String admin_name) {
		this.admin_name = admin_name;
	}
	public String getAdmin_password() {
		return admin_password;
	}
	public void setAdmin_password(String admin_password) {
		this.admin_password = admin_password;
	}
	public boolean isAdmin_permission() {
		return admin_permission;
	}
	public void setAdmin_permission(boolean admin_permission) {
		this.admin_permission = admin_permission;
	}
	
	
	
	
	

}
