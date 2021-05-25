/**
 * @author Tarishi G., S SatyaSri, Vyshavi P., Anju D.
 */
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
	static final double FOIR = 0.5;  // Fixed Obligations to Income Ratio
	
	
	
	/**
	 * Check Spectrum: 
	 *  Tenure <= 30 years
	 *  Monthly Income >= 25000
	 *  Age between 21 and 62
	 *  Loan Amount <= Calculated Max. Loan 
	 *  
	 *  Max Loan Eligibility : Tenure in months * Monthly_Income * FOIR
	 */
	
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

	/**
	 * FIXED EMI
	 * R=  Rate_of_Interest (monthly)
	 * P=  Principal_Amount
	 * t = Tenure is in Year -> convert to Month -> t = t * 12
	 * EMI =  P * R * [(R + 1)^t/((R + 1)^t -1)]  
	 */

	@Override
	public EmiCalculator calculateFixedEmi(EmiCalculator emi) {
		double principle = emi.getPrinciple_amt();
		double rate = emi.getIntrest_rate();
		int tenure = emi.getTenure();
		double r = ((rate/12)/100);
	    emi.setEmi_to_pay((principle * r * Math.pow(r+1, tenure*12))/(Math.pow(r+1, tenure*12)-1));
	  return emi;
	}
	
	// Special Loan Type

	/**
	 * MaxGain  EMI
	 * R=  Rate_of_Interest (monthly) -- Reduced Rate
	 * P=  Principal_Amount
	 * t = Tenure is in Year -> convert to Month -> t = t * 12
	 * EMI =  P * R * [(R + 1)^t/((R + 1)^t -1)]  
	 */
	
	@Override
	public EmiCalculator calculateReducingEmi(EmiCalculator emi) {
		double principle = emi.getPrinciple_amt();
		double rate = emi.getIntrest_rate();
		int tenure = emi.getTenure();
		double r = (((rate-2)/12)/100);
		emi.setEmi_to_pay((principle * r * Math.pow(r+1, tenure*12))/(Math.pow(r+1, tenure*12)-1));
	  return emi;
	}

}
