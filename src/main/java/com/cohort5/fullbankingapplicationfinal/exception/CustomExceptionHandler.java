package com.cohort5.fullbankingapplicationfinal.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"unchecked", "rawtypes"})
@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
        //List<String> message = new ArrayList<>();
        String message = ex.getLocalizedMessage();
        ErrorResponse error = new ErrorResponse(0, message);
        return new ResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(RecordNotFoundException.class)
    public final ResponseEntity<Object> handleRecordNotFoundException(RecordNotFoundException ex, WebRequest request) {
        //List<String> message = new ArrayList<>();
        //message.add(ex.getLocalizedMessage());
        String message = ex.getLocalizedMessage();
        ErrorResponse error = new ErrorResponse(404, message);
        return new ResponseEntity(error, HttpStatus.NOT_FOUND);
    }

//    @Override
//    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
//        List<String> message = new ArrayList<>();
//        for(ObjectError error : ex.getBindingResult().getAllErrors()) {
//            message.add(error.getDefaultMessage());
//        }
//        ErrorResponse error = new ErrorResponse(0, message);
//        return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
//    }

}
