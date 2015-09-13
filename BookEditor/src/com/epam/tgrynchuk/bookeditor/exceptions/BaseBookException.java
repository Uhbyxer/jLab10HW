package com.epam.tgrynchuk.bookeditor.exceptions;

import org.apache.log4j.Logger;

public class BaseBookException extends RuntimeException {
	private static final Logger LOGGER = Logger.getLogger(BaseBookException.class);
	
	private static final long serialVersionUID = 1L;

	public BaseBookException() {
		super();
		
		LOGGER.error(this);
	}
	
	public BaseBookException(String message) {
		super(message);
		
		LOGGER.error(message, this);
	}

	public BaseBookException(Throwable cause) {
		super(cause);
		
		LOGGER.error(toString(), cause);
	}

	public BaseBookException(String message, Throwable cause) {
		super(message, cause);
		
		LOGGER.error(message, cause);
	}
}
