package com.yourcastle.homeloan.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yourcastle.homeloan.entity.EligibilityCalculator;

public interface CalculatorService extends JpaRepository<EligibilityCalculator, Integer> {

	boolean checkEligiblity(EligibilityCalculator e);
}
