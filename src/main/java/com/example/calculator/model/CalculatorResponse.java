package com.example.calculator.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class CalculatorResponse {
    private double result;
    private LocalDate timestamp;
}
