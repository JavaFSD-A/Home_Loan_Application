package com.yourcastle.homeloan.service;


import org.springframework.stereotype.Service;

import com.yourcastle.homeloan.entity.EligiblityCalculator;
import com.yourcastle.homeloan.entity.EmiCalculator;

@Service
public class CalculatorServiceImpl implements CalculatorService {

	
	static final int MINAGE = 23;
	static final int MAXAGE = 62;
	static final int TENURE = 30;
	static final double MINSALARY = 25000;
	
	@Override
	public Double checkEligiblity(EligiblityCalculator eligiblity) {
		if(eligiblity.getAge() >= MINAGE && eligiblity.getAge() <= MAXAGE && eligiblity.getIncome_per_mth()>=MINSALARY && eligiblity.getTenure_yr() <= TENURE)
			{
			eligiblity.setEligiblity(true);
			
			}
		return 50*(0.5 *(eligiblity.getIncome_per_mth()));
	}


	@Override
	public Double calculateFixedEmi(EmiCalculator emi) {
		double principle = emi.getPrinciple_amt();
		double rate = emi.getIntrest_rate();
		int tenure = emi.getTenure();
		int instalment = emi.getNum_instalment();
		return (principle * tenure * rate)/instalment;
	}

	@Override
	public Double calculateReducingEmi(EmiCalculator emi) {
		double remaning_amt = emi.getRemaning_loan_amt();
		double rate = emi.getIntrest_rate(); 
		return remaning_amt * rate;
	}

}
