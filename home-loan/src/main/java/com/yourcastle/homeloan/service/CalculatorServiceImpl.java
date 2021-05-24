package com.yourcastle.homeloan.service;


import org.springframework.stereotype.Service;

import com.yourcastle.homeloan.bean.EligiblityCalculator;
import com.yourcastle.homeloan.bean.EmiCalculator;

@Service
public class CalculatorServiceImpl implements CalculatorService {

	
	static final int MINAGE = 21;
	static final int MAXAGE = 62;
	static final int TENURE = 30;
	static final double MINSALARY = 25000;
	static final double FOIR = 0.5;
	
	@Override
	public EligiblityCalculator checkEligiblity(EligiblityCalculator eligiblity) {
		double emi = 0;
		if(eligiblity.getAge() >= MINAGE && eligiblity.getAge() <= MAXAGE && eligiblity.getIncome_per_mth()>=MINSALARY && eligiblity.getTenure_yr() <= TENURE)
			{
			emi = (eligiblity.getTenure_yr() * 12 * eligiblity.getIncome_per_mth() * FOIR);
			eligiblity.setEligiblity("Eligible");
			eligiblity.setCalculatedMaxVal(emi);	
			}
		else {
			eligiblity.setEligiblity("Not Eligible");
			eligiblity.setCalculatedMaxVal(emi);
		}
		return eligiblity;
	}


	@Override
	public EmiCalculator calculateFixedEmi(EmiCalculator emi) {
		double principle = emi.getPrinciple_amt();
		double rate = emi.getIntrest_rate();
		int tenure = emi.getTenure();
		double r = (rate/1200);
	    emi.setEmi_to_pay((principle * r * Math.pow(r+1, tenure*12))/(Math.pow(r+1, tenure*12)-1));
	  return emi;
	}
	
	// Special Loan for Customers

	@Override
	public EmiCalculator calculateReducingEmi(EmiCalculator emi) {
		double principle = emi.getPrinciple_amt();
		double rate = emi.getIntrest_rate();
		int tenure = emi.getTenure();
		double r = ((rate-2)/1200);
		emi.setEmi_to_pay((principle * r * Math.pow(r+1, tenure*12))/(Math.pow(r+1, tenure*12)-1));
	  return emi;
	}

}
