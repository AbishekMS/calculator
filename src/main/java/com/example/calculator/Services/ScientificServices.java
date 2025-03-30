package com.example.calculator.Services;


import com.example.calculator.model.CalculatorResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class ScientificServices {
    private final HistoryService history ;

    public CalculatorResponse calculate(Double num1, String operation) {
        DateTimeFormatter format= DateTimeFormatter.ofPattern("dd-mm-yyyy hh:mm");
        DecimalFormat df= new DecimalFormat("#.####");

         try{
             Double result= switch(operation){
                 case "sin"-> Math.sin(Math.toRadians(num1));
                 case "cos"-> Math.cos(Math.toRadians(num1));
                 case "tan"-> Math.tan(Math.toRadians(num1));
                 case "log" ->{
                     if (num1<= 0)  throw new IllegalArgumentException("Cannot calculate logarithm of zero or negative number");
                     yield  Math.log10(num1);
                     }
                 case "ln" ->  {
                     if (num1 <= 0) throw  new IllegalArgumentException("Cannot calculate natural logarithm of zero or negative number");
                     yield Math.log(num1);
                     }

                 default ->  throw new IllegalArgumentException("Invalid Operation");
             };
             String expression= operation+"("+num1+")";
             String timing= LocalDateTime.now().format(format);
             CalculatorResponse response=new CalculatorResponse(null,Double.valueOf(df.format(result)), expression, timing,"null");
             // CalculatorResponse(id,result, expression, Calculatedtime, errorMsg)
             history.addToHistory(response);
             return response;

         } catch (Exception e){
             String expression= operation+"("+num1+")";
             String timing = LocalDateTime.now().format(format);
             CalculatorResponse errorResponse=new CalculatorResponse(null,null, expression, timing,e.getMessage());
             history.addToHistory(errorResponse);
             return errorResponse;

         }
    }
}
