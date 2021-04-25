/*
   @author raj
 */
package com.yourcastle.homeloan.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="admin_table")
public class Admin {
	
	@Id
	@Column
	@GeneratedValue
	private int admin_id;
	@Column(length = 30)
	private String admin_name;
	@Column(length=15)
	private String admin_password;
	@Column
	private boolean admin_permission;
	@OneToMany
	@JoinColumn(name="cust_id")
	private Customer customer;
	
	
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
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
