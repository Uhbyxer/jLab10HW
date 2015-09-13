package com.epam.lab11;

import java.util.StringJoiner;

public class ObjectAppender {
	private StringJoiner joiner;
	public ObjectAppender(Object ... obj) {
		joiner = new StringJoiner(", ");
		for(Object o: obj) {
			joiner.add(o.toString());
		}
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return joiner.toString();
	}
	
	
	public static void main(String[] args) {
		ObjectAppender app = new ObjectAppender("Str",1,5,"Hello");
		System.out.println(app.toString());
	}
}
