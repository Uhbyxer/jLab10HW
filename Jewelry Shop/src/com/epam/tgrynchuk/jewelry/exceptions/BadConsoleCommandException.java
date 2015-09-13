package com.epam.tgrynchuk.jewelry.exceptions;

public class BadConsoleCommandException extends BaseJewelryException {
	private static final long serialVersionUID = 1L;

	public BadConsoleCommandException() {
		super();
	}

	public BadConsoleCommandException(String message) {
		super(message);
	}
	
	public BadConsoleCommandException(Throwable cause) {
		super(cause);
	}

	public BadConsoleCommandException(String message, Throwable cause) {
		super(message, cause);
	
	}
}
