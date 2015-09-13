package com.epam.tgrynchuk.bookeditor.exceptions;

public class OpenBookFileException extends BaseBookException {
	private static final long serialVersionUID = 1L;

	public OpenBookFileException() {
		super();
	}

	public OpenBookFileException(String message) {
		super(message);
	}
	
	public OpenBookFileException(Throwable cause) {
		super(cause);
	}

	public OpenBookFileException(String message, Throwable cause) {
		super(message, cause);
	
	}
}
