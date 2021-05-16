package com.yourcastle.homeloan.service;


import org.springframework.stereotype.Service;

import com.yourcastle.homeloan.bean.EligiblityCalculator;
import com.yourcastle.homeloan.bean.EmiCalculator;

@Service
public class CalculatorServiceImpl implements CalculatorService {

	
	static final int MINAGE = 23;
	static final int MAXAGE = 62;
	static final int TENURE = 30;
	static final double MINSALARY = 25000;
	
	@Override
	public EligiblityCalculator checkEligiblity(EligiblityCalculator eligiblity) {
		double emi = 0;
		if(eligiblity.getAge() >= MINAGE && eligiblity.getAge() <= MAXAGE && eligiblity.getIncome_per_mth()>=MINSALARY && eligiblity.getTenure_yr() <= TENURE)
			{
			emi = eligiblity.getTenure_yr()*(eligiblity.getRoi() *(eligiblity.getIncome_per_mth()));
			eligiblity.setEligiblity("Eligible");
			eligiblity.setCalculatedMaxVal(emi);
			//System.out.println(eligiblity.getCalculatedMaxVal());		
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
		int instalment = emi.getNum_instalment();
	  emi.setEmi_to_pay((principle * tenure * rate)/instalment);
	  return emi;
	}

	@Override
	public EmiCalculator calculateReducingEmi(EmiCalculator emi) {
		double remaning_amt = emi.getRemaning_loan_amt();
		double rate = emi.getIntrest_rate(); 
		emi.setEmi_to_pay(remaning_amt * rate);
		return emi;
	}

}
