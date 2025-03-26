package com.example.calculator.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class CalculatorResponse {

    private Integer id;
    private Double result;
    private String expression;
    private String calculatedTime;
    private String errorMsg;


}
