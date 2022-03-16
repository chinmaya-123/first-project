package com.project.shoppingcart.exception;

public class MerchantNotFoundException extends RuntimeException{
    public  MerchantNotFoundException(String message)
    {
        super(message);
    }
}
