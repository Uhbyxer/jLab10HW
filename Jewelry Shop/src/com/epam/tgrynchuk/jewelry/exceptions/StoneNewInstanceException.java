package com.epam.tgrynchuk.jewelry.exceptions;

public class StoneNewInstanceException extends BaseJewelryException {
	private static final long serialVersionUID = 1L;

	public StoneNewInstanceException() {
		super();
	}

	public StoneNewInstanceException(String message) {
		super(message);
	}
	
	public StoneNewInstanceException(Throwable cause) {
		super(cause);
	}

	public StoneNewInstanceException(String message, Throwable cause) {
		super(message, cause);
	
	}
}
