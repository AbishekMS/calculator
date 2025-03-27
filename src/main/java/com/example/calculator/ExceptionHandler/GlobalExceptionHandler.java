package com.example.calculator.ExceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.swing.text.html.parser.Entity;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InvalidOperations.class)
    public ResponseEntity<Map<String,Object>> handleCalculationException(InvalidOperations ino){
        Map<String,Object> response=new HashMap<>();
        response.put("timestamp" , LocalDateTime.now());
        response.put("error","Invalid Operations");
        response.put("message", ino.getMessage());
        response.put("status", HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String,Object>> handleGeneralException(Exception e){
        Map<String,Object> response=new HashMap<>();
        response.put("timestamp" , LocalDateTime.now());
        response.put("error","Invalid Operations");
        response.put("message", e.getMessage());
        response.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
