package com.epam.tgrynchuk.jewelry.exceptions;

public class ClientOpeningException extends BaseJewelryException {
	private static final long serialVersionUID = 1L;

	public ClientOpeningException() {
		super();
	}

	public ClientOpeningException(String message) {
		super(message);
	}
	
	public ClientOpeningException(Throwable cause) {
		super(cause);
	}

	public ClientOpeningException(String message, Throwable cause) {
		super(message, cause);
	
	}
}
