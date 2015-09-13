package com.epam.tgrynchuk.lab5.exceptions;

public class OddEvenInvalidIntervalException extends ApplicationException {
	public OddEvenInvalidIntervalException(String message) {
		super(message);
	}
	
	public OddEvenInvalidIntervalException() {
		super();
	}

	private static final long serialVersionUID = 1L;
}
