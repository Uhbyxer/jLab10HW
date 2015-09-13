package com.epam.tgrynchuk.bookeditor.mvc.models;

import java.util.Comparator;




import com.epam.tgrynchuk.bookeditor.utils.Alphabet;




public  abstract class Token implements Comparable<Token> {
	protected String oldValue;
	private boolean isWord;
	
	public boolean isWord() {
		return isWord;
	}

	@Override
	public String toString() {
		return oldValue;
	}

	public Token(boolean isWord, String oldValue) {
		super();
		this.isWord = isWord;
		this.oldValue = oldValue;
	}

	public String getOldValue() {
		return oldValue;
	}

	public void setOldValue(String oldValue) {
		this.oldValue = oldValue;
	}

	@Override
	public boolean equals(Object obj) {
		return toString().equals(obj.toString());
	}
	@Override
	public int hashCode() {
		return toString().hashCode();
	}
	
	@Override
	public int compareTo(Token other) {
		return oldValue.compareTo(other.oldValue);
	}
	
	public static final Comparator<Token> BY_FIRST_CONSONANT = new Comparator<Token>() {
		@Override
		public int compare(Token first, Token second) {
			Character firstCons = Character.MAX_VALUE;
			Character secondCons = Character.MAX_VALUE;
			
			for(int i = 0; i < first.toString().length(); i++) {
				char ch =  Character.toLowerCase(first.toString().charAt(i));
				if( Alphabet.isConsonants(ch)) {
					firstCons = ch;
					break;
				}
			}
			
			for(int i = 0; i < second.toString().length(); i++) {
				char ch =  Character.toLowerCase(second.toString().charAt(i));
				if( Alphabet.isConsonants(ch)) {
					secondCons = ch;
					break;
				}
			}
			
			return firstCons.compareTo(secondCons);
		}
		
	}; 
	
	public static final Comparator<Token> BY_FIRST_CONSONANT_LAMBDA = 
			(first, second) -> { 
				return ((Integer)  first.toString().toLowerCase().chars()
						.filter(Alphabet::isConsonants).findFirst().orElse(Character.MAX_VALUE)).
						compareTo(second.toString().toLowerCase().chars().filter(Alphabet::isConsonants).findFirst().orElse(Character.MAX_VALUE));
			};
}
