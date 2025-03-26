package com.example.calculator.Controller;
import com.example.calculator.Services.CalculatorServices;
import com.example.calculator.Services.HistoryService;
import lombok.RequiredArgsConstructor;
import com.example.calculator.model.CalculatorResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/normal")
@RequiredArgsConstructor
public class CalculatorController {

   private final CalculatorServices cs;
   private final HistoryService history;

   @PostMapping("/calculate")
    public CalculatorResponse calculate( @RequestParam Double num1,@RequestParam Double num2,@RequestParam String op)
    {
        return cs.calculate(num1,num2,op);
    }

    @GetMapping("/history")
    public List<CalculatorResponse> getHistory(){
       return history.getCalculationHistory();
    }

    @DeleteMapping("/deleteHistoryById/{id}")
    public String deleteHistoryById(@PathVariable Integer id){
       return history.deleteHistoryById(id);
    }

    @DeleteMapping("/deleteHistory")
    public String deleteHistory(){
       return history.cleanHistory();
    }

}

//http://localhost:8080/calculate/10?num2=5&op=add for "Pathvariable"
//http://localhost:8080/calculate?num1=10&num2=5&op=add for RequestParam