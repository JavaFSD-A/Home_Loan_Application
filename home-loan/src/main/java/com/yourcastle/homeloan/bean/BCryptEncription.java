package com.yourcastle.homeloan.bean;

import java.util.Base64;
import java.util.Base64.Encoder;


public class BCryptEncription {

static Encoder passwordEncoder = Base64.getEncoder();
	
	public static String passencoder(String passwd) {
		passwd = passwordEncoder.encodeToString(passwd.getBytes());
		return passwd;
	}
}
