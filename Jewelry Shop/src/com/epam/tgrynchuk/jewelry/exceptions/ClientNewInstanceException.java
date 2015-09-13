package com.epam.tgrynchuk.jewelry.exceptions;

public class ClientNewInstanceException extends BaseJewelryException {
	private static final long serialVersionUID = 1L;

	public ClientNewInstanceException() {
		super();
	}

	public ClientNewInstanceException(String message) {
		super(message);
	}
	
	public ClientNewInstanceException(Throwable cause) {
		super(cause);
	}

	public ClientNewInstanceException(String message, Throwable cause) {
		super(message, cause);
	
	}
}
