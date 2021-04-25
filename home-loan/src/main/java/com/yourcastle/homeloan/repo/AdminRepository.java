package com.yourcastle.homeloan.repo;

import java.util.List;

import com.yourcastle.homeloan.entity.Loan;

public interface AdminRepository {
	
	public List<Loan> getLoanDeatils();
	public List<Loan> getLoan(boolean status);
	public boolean UpdateStatus(int age_limit,int min_sal,int max_tenure);

}
