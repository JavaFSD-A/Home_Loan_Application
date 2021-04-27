package com.yourcastle.homeloan.service;

import com.yourcastle.homeloan.bean.EligiblityCalculator;
import com.yourcastle.homeloan.bean.EmiCalculator;

public interface CalculatorService {

	Double checkEligiblity(EligiblityCalculator eligiblity);
    Double calculateFixedEmi(EmiCalculator emi);
    Double calculateReducingEmi(EmiCalculator emi);
}
