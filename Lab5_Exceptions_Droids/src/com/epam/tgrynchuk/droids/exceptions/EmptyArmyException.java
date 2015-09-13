package com.epam.tgrynchuk.droids.exceptions;



public class EmptyArmyException extends DroidException{

	private static final long serialVersionUID = 1L;

	public EmptyArmyException() {
		super();
	}

	public EmptyArmyException(String message) {
		super(message);
	}



}