package com.epam.tgrynchuk.droids.exceptions;

public class DroidException extends RuntimeException {

	public DroidException() {
		super();
	}
	
	public DroidException(String message) {
		super(message);
	}

	public DroidException(Throwable cause) {
		super(cause);
	}

	public DroidException(String message, Throwable cause) {
		super(message, cause);
	
	}

	private static final long serialVersionUID = 1L;
	
}
