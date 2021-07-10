package com.grit.LoanApproval.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(UnAuthorisedUser.class)
	public ResponseEntity<Object> handleUnAuthorisedException(UnAuthorisedUser unAuthorisedUser ) {
		
		return new ResponseEntity<Object>(unAuthorisedUser.getMessage(), HttpStatus.UNAUTHORIZED);
	}
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handleBadRequestException(Exception exception ) {
		System.out.println("Exception class call");
		return new ResponseEntity<Object>(exception.getMessage(), HttpStatus.BAD_REQUEST);
	}
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		System.out.println("3rd method call ");
		
		return new ResponseEntity<Object>(ex.getMessage(), HttpStatus.UNAUTHORIZED);
	}
	}

