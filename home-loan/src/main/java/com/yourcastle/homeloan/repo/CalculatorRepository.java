package com.yourcastle.homeloan.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yourcastle.homeloan.entity.EligiblityCalculator;

public interface CalculatorRepository extends JpaRepository<EligiblityCalculator, Integer> {

}
