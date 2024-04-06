package org.example.medium.com.vending;

public class CapacityMaxedOutException extends RuntimeException{

    public CapacityMaxedOutException() {
        super();
    }
    public CapacityMaxedOutException(String message){
        super(message);
    }
}
