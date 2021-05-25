/**
 * @author Tarishi G.
 */

package com.yourcastle.homeloan.bean;

import java.util.Base64;
import java.util.Base64.Encoder;


public class Encription {

static Encoder passwordEncoder = Base64.getEncoder();
	
	public static String passencoder(String passwd) {
		passwd = passwordEncoder.encodeToString(passwd.getBytes());
		return passwd;
	}
}
