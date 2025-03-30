package com.example.calculator.Services;
import com.example.calculator.ExceptionHandler.InvalidOperations;
import com.example.calculator.model.CalculatorResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
@AllArgsConstructor
public class CalculatorServices {

    private final HistoryService history;

    public CalculatorResponse calculate(Double num1, Double num2, String operation) {
        DateTimeFormatter format= DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

        try {
            double result = switch (operation.toLowerCase().trim()) {
                case "add" -> num1 + num2;
                case "subtract" -> num1 - num2;
                case "multiply" -> num1 * num2;
                case "divide" -> {
                    if (num2 == 0)
                        throw new InvalidOperations("Cannot divide by zero");
                    yield num1/num2;
                }
                case "power" -> Math.pow(num1, num2);
                case "root" -> {
                    if(num1<0 && num2%2==0)
                        throw new InvalidOperations("Cannot take even number for negative numbers");
                    yield Math.pow(num1,num2);
                }
                case "module" -> {
                    if(num2==0) throw new InvalidOperations("second number should not be zero");
                    yield num1%num2;
                }
                case "percentage" -> (num1/num2)*100;
                default -> throw new InvalidOperations("Invalid operation ");
            };
            String operator= switch(operation.toLowerCase().trim()){
                case "add"->" + ";
                case "subtract"-> " - ";
                case "multiply" ->" * ";
                case "divide" -> " / ";
                case "power" -> " ^ ";
                case "root" -> " √ "; //alt+ 251
                case "module" -> " % ";
                case "percentage"->" % of ";
                default -> throw new InvalidOperations("Unexpected value: " + operation.toLowerCase()); //generated through error message
            };
            String expression = num1+operator+num2+" = "+result;
            String timing= LocalDateTime.now().format(format);
            CalculatorResponse response= new CalculatorResponse(null,result, expression,timing,null);
            // CalculatorResponse(result, expression, Calculatedtime, errorMsg)
            history.addToHistory(response);
            return response;


        } catch( InvalidOperations e){
            String expression= num1+" "+operation+" "+num2;
            String timing= LocalDateTime.now().format(format);
            CalculatorResponse errorResponse= new CalculatorResponse(null,null, expression, timing,e.getMessage() );
            history.addToHistory(errorResponse);
            return errorResponse;
        }

    }

}