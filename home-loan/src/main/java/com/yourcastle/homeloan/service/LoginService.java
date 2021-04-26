package com.yourcastle.homeloan.service;

import com.yourcastle.homeloan.entity.Login;

public interface LoginService {

	Login authenticationUser(Login login, String role);
}
