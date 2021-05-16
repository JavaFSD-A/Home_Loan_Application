package com.yourcastle.homeloan.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	
	@PostMapping(value = "/eligiblityCheck", consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> checkEligiblity(@RequestBody EligiblityCalculator e) {
		EligiblityCalculator elg = service.checkEligiblity(e);
			return  new ResponseEntity<EligiblityCalculator>(elg, HttpStatus.OK);
	}
	
	@PostMapping(value = "/fixedEmi", consumes = "application/json")
	public ResponseEntity<?> calculateFixedEmi(@RequestBody EmiCalculator emi) {
		EmiCalculator fixed = service.calculateFixedEmi(emi);
		return new ResponseEntity<EmiCalculator>(fixed, HttpStatus.OK);
	}
	
	@PostMapping(value = "/reducingEmi", consumes = "application/json")
	public ResponseEntity<?> calculateReducingEmi(@RequestBody EmiCalculator emi) {
		EmiCalculator reducing = service.calculateReducingEmi(emi);
		return new ResponseEntity<EmiCalculator>(reducing, HttpStatus.OK);
	}
	
}
