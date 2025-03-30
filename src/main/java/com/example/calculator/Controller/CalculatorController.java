package com.example.calculator.Controller;
import com.example.calculator.ExceptionHandler.InvalidOperations;
import com.example.calculator.Services.CalculatorServices;
import com.example.calculator.Services.HistoryService;
import lombok.RequiredArgsConstructor;
import com.example.calculator.model.CalculatorResponse;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/normal")
//@RequiredArgsConstructor   // either use this annotation for final fields or avoid final and use @Autowired annotation
public class CalculatorController {

    private final CalculatorServices cs;
    private final HistoryService history;

    @Autowired
    public CalculatorController(CalculatorServices cs,HistoryService his){
        this.cs=cs;
        history=his;
    }

    @PostMapping("/calculate")
    public ResponseEntity<CalculatorResponse> calculate(@RequestParam Double num1, @RequestParam Double num2, @RequestParam(required = false) String op)
    {
        if( op==null || op.isBlank()) throw new InvalidOperations("Mention the name of Operation to be performed");
        return ResponseEntity.ok(cs.calculate(num1,num2,op));
    }

    @GetMapping("/history")
    public ResponseEntity<List<CalculatorResponse>> getHistory(){
       return ResponseEntity.ok(history.getCalculationHistory());
    }

    @DeleteMapping("/deleteHistoryById/{id}")
    public ResponseEntity<String> deleteHistoryById(@PathVariable Integer id){
       return ResponseEntity.ok(history.deleteHistoryById(id));
    }

    @DeleteMapping("/deleteHistory")
    public ResponseEntity<String> deleteHistory(){
       return ResponseEntity.ok(history.cleanHistory());
    }

    @DeleteMapping("/deleteHistoryfromDB")
    public ResponseEntity<String> deleteHistoryFromDB(){
        return ResponseEntity.ok(history.clearHistoryFromH2DB());
    }

    @GetMapping("/historyfromDB")
    public ResponseEntity<List<CalculatorResponse>> getHistoryfromDB(){
        return ResponseEntity.ok(history.getCalculationHistoryfromH2DB());
    }

    @DeleteMapping("/deletefromDB/{id}")
    public ResponseEntity<String> deleteHistoryFromH2DB(@PathVariable Integer id){
        return ResponseEntity.ok(history.deleteHistoryByIdfromH2DB(id));
    }

}

//http://localhost:8080/calculate/10?num2=5&op=add for "Pathvariable"
//http://localhost:8080/calculate?num1=10&num2=5&op=add for RequestParam