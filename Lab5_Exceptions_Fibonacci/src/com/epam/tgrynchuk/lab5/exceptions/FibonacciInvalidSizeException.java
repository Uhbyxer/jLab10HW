package com.epam.tgrynchuk.lab5.exceptions;

public class FibonacciInvalidSizeException extends ApplicationException {
	public FibonacciInvalidSizeException(String message) {
		super(message);
	}
	
	public FibonacciInvalidSizeException() {
		super();
	}

	private static final long serialVersionUID = 1L;
}
