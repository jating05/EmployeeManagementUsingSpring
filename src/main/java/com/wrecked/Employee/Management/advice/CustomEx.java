package com.wrecked.Employee.Management.advice;

public class CustomEx extends RuntimeException{
    public CustomEx(String message) {
        super(message);
        System.out.println("Test in Custom Java file");
    }
}
