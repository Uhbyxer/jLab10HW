package com.epam.tgrynchuk.jewelry.exceptions;

public class StoneOpeningException extends BaseJewelryException {
	private static final long serialVersionUID = 1L;

	public StoneOpeningException() {
		super();
	}

	public StoneOpeningException(String message) {
		super(message);
	}
	
	public StoneOpeningException(Throwable cause) {
		super(cause);
	}

	public StoneOpeningException(String message, Throwable cause) {
		super(message, cause);
	
	}
}
