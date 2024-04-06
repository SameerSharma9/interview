package org.example.medium.com.vending;

public class ProductNotAvailableException extends RuntimeException{

    public ProductNotAvailableException(String message) {
        super(message);
    }
}
