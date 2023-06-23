package com.anees.spring;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ClockExceptionHandler extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		ErrorResponse errorResponse= new ErrorResponse("Unable to process request",HttpStatus.BAD_REQUEST.value());
		return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(ClockException.class)
	public ResponseEntity<Object> clockExceptionHandler(ClockException clockException,WebRequest request) {
		
		ErrorResponse errorResponse= new ErrorResponse(clockException.getMessage(),clockException.getHttpStatus().value());
		return new ResponseEntity<>(errorResponse,clockException.getHttpStatus());
		
	}
	
}
