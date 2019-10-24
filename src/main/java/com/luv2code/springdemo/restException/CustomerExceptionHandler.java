package com.luv2code.springdemo.restException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomerExceptionHandler {
	
	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse> handleException(CustomerNotFoundException exc){
		CustomerErrorResponse theCustomerException = new CustomerErrorResponse();
		theCustomerException.setStatusCode(HttpStatus.NOT_FOUND.value());
		theCustomerException.setTimeStamp(System.currentTimeMillis());
		theCustomerException.setMessge(exc.getMessage());		
		return new ResponseEntity<>(theCustomerException,HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse> handleException(Exception exc){
		CustomerErrorResponse theCustomerException = new CustomerErrorResponse();
		theCustomerException.setStatusCode(HttpStatus.BAD_REQUEST.value());
		theCustomerException.setTimeStamp(System.currentTimeMillis());
		theCustomerException.setMessge(exc.getMessage());		
		return new ResponseEntity<>(theCustomerException,HttpStatus.BAD_REQUEST);
		
	}

}
