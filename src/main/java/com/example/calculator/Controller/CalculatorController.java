package com.example.calculator.Controller;

import com.example.calculator.Services.CalculatorServices;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import com.example.calculator.model.CalculatorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
//@AllArgsConstructor
@RequiredArgsConstructor
public class CalculatorController {

   private final CalculatorServices cs;

    @GetMapping("/welcome")
    public String welcome(){
        return "Welcome man";
    }
   @GetMapping("/calculate/{id}")
    public CalculatorResponse calculate( @PathVariable double id,@RequestParam double num2,
                                         @RequestParam String op)
    {
        return cs.calculate(id,num2,op);
    }

}

//http://localhost:8080/calculate/10?num2=5&op=add for "Pathvariable"
//http://localhost:8080/calculate?num1=10&num2=5&op=add for RequestParam