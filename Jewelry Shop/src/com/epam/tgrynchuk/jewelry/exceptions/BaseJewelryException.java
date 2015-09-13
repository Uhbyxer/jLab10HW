package com.epam.tgrynchuk.jewelry.exceptions;

import org.apache.log4j.Logger;

public class BaseJewelryException extends RuntimeException {
	private static final Logger LOGGER = Logger.getLogger(BaseJewelryException.class);
	
	private static final long serialVersionUID = 1L;

	public BaseJewelryException() {
		super();
		
		LOGGER.error(this);
	}
	
	public BaseJewelryException(String message) {
		super(message);
		
		LOGGER.error(message, this);
	}

	public BaseJewelryException(Throwable cause) {
		super(cause);
		
		LOGGER.error(toString(), cause);
	}

	public BaseJewelryException(String message, Throwable cause) {
		super(message, cause);
		
		LOGGER.error(message, cause);
	}
}
