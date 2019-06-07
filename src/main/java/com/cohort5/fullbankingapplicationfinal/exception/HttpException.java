package com.cohort5.fullbankingapplicationfinal.exception;


import org.springframework.http.HttpStatus;



public class HttpException extends RuntimeException{

	private static final long serialVersionUID = 1l;
	String message;
	HttpStatus status;

	public HttpException(){}


	public HttpException(String message, HttpStatus status) {
		super(message);
		this.status = status;
	}
}
