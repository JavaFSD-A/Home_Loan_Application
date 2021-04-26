package com.yourcastle.homeloan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yourcastle.homeloan.entity.EligiblityCalculator;
import com.yourcastle.homeloan.repo.CalculatorRepository;

@Service
public class CalculatorServiceImpl implements CalculatorService {
  
	@Autowired
	private CalculatorRepository crepo;
	
	static final int MINAGE = 23;
	static final int MAXAGE = 62;
	static final int TENURE = 30;
	static final double MINSALARY = 25000;
	
	@Override
	public Double checkEligiblity(EligiblityCalculator e) {
		if(e.getAge() >= MINAGE && e.getAge() <= MAXAGE && e.getIncome_per_mth()>=MINSALARY && e.getTenure_yr() <= TENURE)
			{
			e.setEligiblity(true);
			
			}
		return 50*(0.5 *(e.getIncome_per_mth()));
	}

}
