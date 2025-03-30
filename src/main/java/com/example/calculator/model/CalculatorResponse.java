package com.example.calculator.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name="calc_history")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CalculatorResponse {

  //  private static int cnt=1;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Double result;
    private String expression;
    @Column(name="calculated_time")
    private String calculatedTime;
    @Column(name="error_msg")
    private String errorMsg;

/*
    public CalculatorResponse(Double result, String expression, String timing, String message) {
        this.id=cnt++;
        this.result = result;
        this.expression = expression;
        this.calculatedTime = timing;
        this.errorMsg = message;

    }
*/
}
