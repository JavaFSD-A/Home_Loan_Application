package com.yourcastle.homeloan.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yourcastle.homeloan.entity.EligibilityCalculator;

public interface CalculatorRepository extends JpaRepository<EligibilityCalculator, Integer>{

}
