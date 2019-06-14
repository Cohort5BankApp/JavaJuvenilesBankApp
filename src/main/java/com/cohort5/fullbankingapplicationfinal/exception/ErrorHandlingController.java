package com.cohort5.fullbankingapplicationfinal.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandlingController {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponse> generalException() {
        ExceptionResponse error = new ExceptionResponse();
        error.setCode(HttpStatus.NOT_FOUND.value());
        error.setDescription("Error");
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
//
//    @ExceptionHandler(CustomException.class)
//    public ResponseEntity<ExceptionResponse> specialException(CustomException e) throws Exception {
//        ExceptionResponse error = new ExceptionResponse();
//        error.setCode(HttpStatus.NOT_FOUND.value());
//        error.setDescription(e.getMessage());
//
//        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
//    }




}
