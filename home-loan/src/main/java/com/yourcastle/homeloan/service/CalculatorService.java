package com.yourcastle.homeloan.service;

import com.yourcastle.homeloan.entity.EligiblityCalculator;
import com.yourcastle.homeloan.entity.EmiCalculator;

public interface CalculatorService {

	Double checkEligiblity(EligiblityCalculator eligiblity);
    Double calculateFixedEmi(EmiCalculator emi);
    Double calculateReducingEmi(EmiCalculator emi);
}
