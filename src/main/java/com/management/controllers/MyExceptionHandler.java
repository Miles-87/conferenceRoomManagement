package com.management.controllers;

import com.management.exceptions.ExceptionInfo;
import com.management.exceptions.MyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler(MyException.class)
    public ResponseEntity<ExceptionInfo> myExceptionHandler(MyException e) {
        return new ResponseEntity<>(e.getExceptionInfo(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
