package com.project.shoppingcart.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    ErrorResponse error = new ErrorResponse();

    @ExceptionHandler(EmailFoundException.class)
    public ResponseEntity<ErrorResponse> handler(EmailFoundException ex) {
        error.setStatus(HttpStatus.NOT_ACCEPTABLE.value());
        error.setMessage(ex.getMessage());
        error.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<>(error, HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorResponse> handler(RuntimeException ex) {
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(ex.getMessage());
        error.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(ConsumerNotFoundException.class)
    public ResponseEntity<ErrorResponse> handler(ConsumerNotFoundException ex) {
        error.setStatus(HttpStatus.NOT_ACCEPTABLE.value());
        error.setMessage(ex.getMessage());
        error.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<>(error, HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(CategoryNotFoundException.class)
    public ResponseEntity<ErrorResponse> handler(CategoryNotFoundException ex) {
        error.setStatus(HttpStatus.NOT_ACCEPTABLE.value());
        error.setMessage(ex.getMessage());
        error.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<>(error, HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(MerchantNotFoundException.class)
    public ResponseEntity<ErrorResponse> handler(MerchantNotFoundException ex) {
        error.setStatus(HttpStatus.NOT_ACCEPTABLE.value());
        error.setMessage(ex.getMessage());
        error.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<>(error, HttpStatus.NOT_ACCEPTABLE);
    }
}

