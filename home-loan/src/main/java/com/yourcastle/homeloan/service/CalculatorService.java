package com.yourcastle.homeloan.service;

import com.yourcastle.homeloan.bean.EligiblityCalculator;
import com.yourcastle.homeloan.bean.EmiCalculator;

public interface CalculatorService {

	EligiblityCalculator checkEligiblity(EligiblityCalculator eligiblity);
	EmiCalculator calculateFixedEmi(EmiCalculator emi);
	EmiCalculator calculateReducingEmi(EmiCalculator emi);
}
