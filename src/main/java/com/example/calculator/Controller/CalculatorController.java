package com.example.calculator.Controller;
import com.example.calculator.Services.CalculatorServices;
import lombok.RequiredArgsConstructor;
import com.example.calculator.model.CalculatorResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/calculator")
@RequiredArgsConstructor
public class CalculatorController {

   private final CalculatorServices cs;

   @PostMapping("/calculate")
    public CalculatorResponse calculate( @RequestParam Double num1,@RequestParam Double num2,@RequestParam String op)
    {
        return cs.calculate(num1,num2,op);
    }

    @GetMapping("/history")
    public List<CalculatorResponse> getHistory(){
       return cs.getCalculationHistory();
    }

    @DeleteMapping("/deleteHistoryById/{id}")
    public String deleteHistoryById(@PathVariable Integer id){
       return cs.deleteHistoryById(id);
    }

    @DeleteMapping("/deleteHistory")
    public String deleteHistory(){
       return cs.cleanHistory();
    }

}

//http://localhost:8080/calculate/10?num2=5&op=add for "Pathvariable"
//http://localhost:8080/calculate?num1=10&num2=5&op=add for RequestParam