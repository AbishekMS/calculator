package com.example.calculator.Controller;

import com.example.calculator.ExceptionHandler.InvalidOperations;
import com.example.calculator.Services.HistoryService;
import com.example.calculator.Services.ScientificServices;
import com.example.calculator.model.CalculatorResponse;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/scientific")
@RequiredArgsConstructor
public class ScientificController {
    private final ScientificServices scientifc;
    private final HistoryService history;

    @PostMapping("/calculate")
    public CalculatorResponse calculate(@RequestParam Double num1, @RequestParam String op){
           if(op.isBlank() || op==null) throw new InvalidOperations("Mention the name of Operation to be performed");

            return scientifc.calculate(num1,op);
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
