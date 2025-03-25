package com.example.calculator.Services;

import com.example.calculator.model.CalculatorResponse;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class CalculatorServices {
    public CalculatorResponse calculate(double num1, double num2, String operation) {
        double result;
        switch (operation.toLowerCase()) {
            case "add":
                result = num1 + num2;
                break;
            case "subtract":
                result = num1 - num2;
                break;
            case "multiply":
                result = num1 * num2;
                break;
            case "divide":
                if (num2 == 0) throw new IllegalArgumentException("Cannot divide by zero");
                result = num1 / num2;
                break;
            default:
                throw new IllegalArgumentException("Invalid operation");
        }
        return new CalculatorResponse(result, LocalDate.now());
    }
}