
package com.project.shoppingcart.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

	@ExceptionHandler(EmailExistException.class)
	public ResponseEntity<ErrorResponse> handler(EmailExistException ex)
	{
		ErrorResponse error=new ErrorResponse();
		error.setStatus(HttpStatus.NOT_ACCEPTABLE.value());
		error.setMessage(ex.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<>(error,HttpStatus.NOT_ACCEPTABLE);		
	}
	
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<ErrorResponse> handler(RuntimeException ex)
	{
		ErrorResponse error=new ErrorResponse();
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(ex.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);		

	}
}

