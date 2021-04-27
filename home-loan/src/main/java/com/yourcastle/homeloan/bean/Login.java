package com.yourcastle.homeloan.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Login {
	
	private int phone_no;
	//private String email;
	private String login_passwd;

	
	
	
	public Login(int phone_no, String login_passwd, String role) {
		super();
		this.phone_no = phone_no;
		this.login_passwd = login_passwd;
	}
	
	public int getPhone_no() {
		return phone_no;
	}
	public void setPhone_no(int phone_no) {
		this.phone_no = phone_no;
	}
	public String getLogin_passwd() {
		return login_passwd;
	}
	public void setLogin_passwd(String login_passwd) {
		this.login_passwd = login_passwd;
	}
	
	

}
