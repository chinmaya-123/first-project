package com.project.shoppingcart.exception;

public class ConsumerNotFoundException extends RuntimeException {
    public ConsumerNotFoundException(String message)
    {
        super(message);
    }
}
