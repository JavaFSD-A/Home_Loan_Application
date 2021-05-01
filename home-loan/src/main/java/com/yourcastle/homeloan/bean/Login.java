package com.yourcastle.homeloan.bean;

public class Login {

	private int phone_no;
	private String email;
	private String login_passwd;
	private String role;

	public Login(int phone_no, String email, String login_passwd, String role) {
		super();
		this.phone_no = phone_no;
		this.email = email;
		this.login_passwd = login_passwd;
		this.role = role;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
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
