package com.epam.tgrynchuk.lab5.exceptions;

public class NoIntegerInputException extends ApplicationException {
	public NoIntegerInputException(String message) {
		super(message);
	}
	
	public NoIntegerInputException() {
		super();
	}
	
	private static final long serialVersionUID = 1L;

}
