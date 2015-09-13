package com.epam.tgrynchuk.bookeditor.mvc.models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.epam.tgrynchuk.bookeditor.utils.Alphabet;

public class Text extends LinkedList<Sentence> {
	private String oldValue;

	public Text(String oldValue) {
		super();
		this.oldValue = oldValue;
	}

	public Text() {
		super();
		this.oldValue = "";
	}

	public String getOldValue() {
		return oldValue;
	}

	public void setOldValue(String oldValue) {
		this.oldValue = oldValue;
	}

	@Override
	public String toString() {
		StringBuilder res = new StringBuilder();
		
		forEach(x -> res.append(x));
		
		return res.toString();
	}
	
	public void parse() {
		if (!isEmpty())
			clear();
		
		String patternString = "\\.\\.\\. |\\!\\.\\. |\\?\\.\\. |\\. |\\! |\\? ";

		StringBuilder pathBuilder = new StringBuilder(patternString)
			.append(patternString.replace(" ", "\t"))
			.append(patternString.replace(" ", "\n"));
		
		patternString = pathBuilder.toString();

		Pattern pattern = Pattern.compile(patternString);
		Matcher matcher = pattern.matcher(oldValue);

		List<Integer> arr = new ArrayList<>();
		arr.add(0);

		int count = 0;
		while (matcher.find()) {
			count++;

			if (matcher.start() != 0) {
				arr.add(matcher.start());
			}

			if (matcher.end() != oldValue.length()) {
				arr.add(matcher.end());
			}
		}

		arr.add(oldValue.length());

		StringBuilder sb = new StringBuilder();
		boolean clearBuilder = false;
		for (int i = 0; i < arr.size() - 1; i++) {

			sb.append(oldValue.substring(arr.get(i), arr.get(i + 1)));
			if (clearBuilder) {
				if (sb.toString().trim().length() > 0)
					add(new Sentence(sb.toString()));
				sb.delete(0, sb.length());
			}

			clearBuilder = !clearBuilder;
		}
		if (clearBuilder) {
			if (sb.toString().trim().length() > 0)
				add(new Sentence(sb.toString()));
		}
		
		forEach(x -> x.parse());
	}
	
	
	public Set<Token> getSortedWords() {
		return getSortedWords(Token.BY_FIRST_CONSONANT);
	}	
	
	public Set<Token> getSortedWords(Comparator<? super Token> comparator) {
		List<Token> words = new ArrayList<>();
		
		for(Sentence sent: this) {
			for(Token t: sent) {
				if(t.isWord()) {
					if(t.toString().length() == 0) continue;
					
					if(Alphabet.isVowel(Character.toLowerCase(t.toString().charAt(0))))
						words.add(t);
					
				}
			}
		}
		
		words.sort(comparator);
		
		return new LinkedHashSet<Token>(words);
	}	
	
	

}
