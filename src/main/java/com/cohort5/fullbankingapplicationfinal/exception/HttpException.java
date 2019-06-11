package com.cohort5.fullbankingapplicationfinal.exception;


import org.springframework.http.HttpStatus;



public class HttpException extends RuntimeException{

	private static final long serialVersionUID = 1l;
	String message;
	HttpStatus status;

	public HttpException(){}


	public HttpException(HttpStatus status, String message) {
		super(message);
		this.status = status;
	}

	@Override
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}
}
