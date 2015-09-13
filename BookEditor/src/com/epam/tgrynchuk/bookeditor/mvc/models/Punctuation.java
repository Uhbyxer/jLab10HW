package com.epam.tgrynchuk.bookeditor.mvc.models;

public class Punctuation extends Token {

	public Punctuation(String oldValue) {
		super(false, oldValue);
	}
	
	public void setOldValue(String oldValue) {
		super.oldValue = oldValue;
	}

}
