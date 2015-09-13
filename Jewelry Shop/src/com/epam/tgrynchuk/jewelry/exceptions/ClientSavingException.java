package com.epam.tgrynchuk.jewelry.exceptions;

public class ClientSavingException extends BaseJewelryException {
	private static final long serialVersionUID = 1L;

	public ClientSavingException() {
		super();
	}

	public ClientSavingException(String message) {
		super(message);
	}
	
	public ClientSavingException(Throwable cause) {
		super(cause);
	}

	public ClientSavingException(String message, Throwable cause) {
		super(message, cause);
	
	}
}
