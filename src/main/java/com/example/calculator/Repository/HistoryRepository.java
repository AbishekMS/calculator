package com.example.calculator.Repository;

import com.example.calculator.model.CalculatorResponse;
import org.springframework.data.jpa.repository.JpaRepository;


// Integer is the return type of primary key of CalculatorResponse class
public interface HistoryRepository extends JpaRepository<CalculatorResponse, Integer> {

}
