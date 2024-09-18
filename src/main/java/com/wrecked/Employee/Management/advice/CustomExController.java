package com.wrecked.Employee.Management.advice;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExController {

    @ExceptionHandler(CustomEx.class)
    public CustomEx customExceptionHandler(CustomEx ex){
        return ex;
//        return new CustomEx("Hello");
    }

}
