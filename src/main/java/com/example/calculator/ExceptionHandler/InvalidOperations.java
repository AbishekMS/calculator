package com.example.calculator.ExceptionHandler;

public class InvalidOperations extends RuntimeException {
    public InvalidOperations(String msg){
        super(msg);
    }
    public InvalidOperations(String msg, Throwable cause){
        super(msg,cause);
    }
    public InvalidOperations(Throwable cause){
        super(cause);
    }
}
