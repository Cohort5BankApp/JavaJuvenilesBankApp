package com.cohort5.fullbankingapplicationfinal.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class HttpException extends RuntimeException{

	private static final long serialVersionUID = 1l;

	public HttpException(){}

	public HttpException(String message){
		super(message);
	}

	public HttpException(String message, Throwable cause){
		super(message, cause);
	}


}
