package com.yourcastle.homeloan.bean;

public class Login {

	private String phone_no;
	private String email;
	private String login_passwd;
	
	public Login() {
		// TODO Auto-generated constructor stub
	}

	public Login(String phone_no, String login_passwd) {
		super();
		this.phone_no = phone_no;
		this.login_passwd = login_passwd;
	}


	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone_no() {
		return phone_no;
	}

	public void setPhone_no(String phone_no) {
		this.phone_no = phone_no;
	}

	public String getLogin_passwd() {
		return login_passwd;
	}

	public void setLogin_passwd(String login_passwd) {
		this.login_passwd = login_passwd;
	}
}
