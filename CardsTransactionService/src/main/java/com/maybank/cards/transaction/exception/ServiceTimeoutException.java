package com.maybank.cards.transaction.exception;

public class ServiceTimeoutException extends RuntimeException{
	public ServiceTimeoutException(String message) {
        super(message);
    }
	
}
