package com.epam.tgrynchuk.bookeditor.utils;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Alphabet {
	private static final Set<Character> ALPHABET, CONSONANTS, VOWELS;

	static {

		
		VOWELS = new TreeSet<>(Arrays.asList('a','e','i','o','u'));
		ALPHABET = new TreeSet<>();
		
		for (Character ch = 'a'; ch <= 'z'; ch++) {
			ALPHABET.add(ch);
		}	
//		Function<Integer, Character> mapToChar = x -> IntToChar(x);
//	    Set<Character> set =  IntStream.rangeClosed((int) 'a', (int) 'z').boxed().map(x -> mapToChar.apply(x)).collect(Collectors.toSet());		
		
		CONSONANTS = ALPHABET.stream().filter(x -> !VOWELS.contains(x)).collect(Collectors.toSet());
	}

	public static Set<Character> getAlphabet() {
		return ALPHABET;
	}

	public static Set<Character> getConsonants() {
		return CONSONANTS;
	}

	public static Set<Character> getVowels() {
		return VOWELS;
	}
	
	public static boolean isConsonants(char ch) {
		return CONSONANTS.contains(ch);
	}	
	public static boolean isConsonants(int ch) {
		return isConsonants((char) ch);
	}
	
	public static boolean isVowel(char ch) {
		return VOWELS.contains(ch);
	}	
	public static boolean isVowel(int ch) {
		return isConsonants((char) ch);
	}

}
