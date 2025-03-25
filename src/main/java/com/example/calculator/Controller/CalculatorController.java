package com.example.calculator.Controller;

import com.example.calculator.Services.CalculatorServices;
import lombok.RequiredArgsConstructor;

import com.example.calculator.model.CalculatorResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class CalculatorController {
   private final CalculatorServices cs;

    @GetMapping("/welcome")
    public String welcome(){
        return "Welcome man";
    }
   @GetMapping("/calculate/{num1}")
    public CalculatorResponse calculate( @PathVariable double num1,@RequestParam double num2,
                                         @RequestParam String op)
    {

        return cs.calculate(num1,num2,op);
    }

}
