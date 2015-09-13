package com.epam.tgrynchuk.lab5.exceptions;

public abstract class ApplicationException extends RuntimeException {
	
	public ApplicationException(String message) {
		super(message);
	}
	
	public ApplicationException() {
		super();
	}

	private static final long serialVersionUID = 1L;

}
