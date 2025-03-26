package com.example.calculator.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class CalculatorResponse {

    private static int cnt=1;
    private Integer id;
    private Double result;
    private String expression;
    private String calculatedTime;
    private String errorMsg;


    public CalculatorResponse(Double result, String expression, String timing, String message) {
        this.id=cnt++;
        this.result = result;
        this.expression = expression;
        this.calculatedTime = timing;
        this.errorMsg = message;

    }

}
