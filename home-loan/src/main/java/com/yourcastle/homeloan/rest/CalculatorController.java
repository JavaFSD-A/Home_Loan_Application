package com.yourcastle.homeloan.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yourcastle.homeloan.bean.EligiblityCalculator;
import com.yourcastle.homeloan.bean.EmiCalculator;
import com.yourcastle.homeloan.service.CalculatorService;

@CrossOrigin()
@RestController
@RequestMapping("/calculator")
public class CalculatorController {

	@Autowired
	private CalculatorService service;
	
	@PostMapping(value = "/eligiblityCheck", consumes = "application/json")
	public String checkEligiblity(@RequestBody EligiblityCalculator e) {
		double elg = service.checkEligiblity(e);
		if( e.isEligiblity() == true)
			return "Eligiblity : eligible \nMaximum loan value : " + elg;
		else
			return "Eligiblity : Not eligible";
	}
	
	@PostMapping(value = "/fixedEmi", consumes = "application/json")
	public String calculateFixedEmi(@RequestBody EmiCalculator emi) {
		double fixed = service.calculateFixedEmi(emi);
		return "Calculated Fixed EMI : Rs." + fixed;
	}
	
	@PostMapping(value = "/reducingEmi", consumes = "application/json")
	public String calculateReducingEmi(@RequestBody EmiCalculator emi) {
		double reducing = service.calculateReducingEmi(emi);
		return "Calculated Reducing EMI : Rs." + reducing;
	}
	
}
