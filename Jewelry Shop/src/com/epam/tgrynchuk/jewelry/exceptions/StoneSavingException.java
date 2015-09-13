package com.epam.tgrynchuk.jewelry.exceptions;

public class StoneSavingException extends BaseJewelryException {
	private static final long serialVersionUID = 1L;

	public StoneSavingException() {
		super();
	}

	public StoneSavingException(String message) {
		super(message);
	}
	
	public StoneSavingException(Throwable cause) {
		super(cause);
	}

	public StoneSavingException(String message, Throwable cause) {
		super(message, cause);
	
	}
}
