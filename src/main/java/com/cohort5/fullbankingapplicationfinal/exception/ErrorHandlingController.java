package com.cohort5.fullbankingapplicationfinal.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandlingController {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponse> generalException(Exception e) throws Exception {
        ExceptionResponse error = new ExceptionResponse();
        error.setCode(HttpStatus.NOT_FOUND.value());
        error.setDescription("Error");
        return new ResponseEntity<ExceptionResponse>(error, HttpStatus.NOT_FOUND);
    }

}
