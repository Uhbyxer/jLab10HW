package com.epam.tgrynchuk.bookeditor.mvc.models;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Sentence extends LinkedList<Token> {
	private String oldValue;

	public String getOldValue() {
		return oldValue;
	}

	public void setOldValue(String oldValue) {
		this.oldValue = oldValue;
	}

	public Sentence(String oldValue) {
		super();
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

		String patternPunct = "\\.\\.\\. |\\!\\.\\. |\\?\\.\\. |\\. |\\! |\\? |\\, |\\; |\\: ";
		String patternSymb = "/\\*\\*|\\*\\*/|//|/\\*|\\*/|\\~|\\`|\\\\|@|#|\\$|%|\\^|\\*=|\\+\\+|\\-\\-|\\+=|\\-=|/=|==|!=|<<<|>>>|<>|<<|>>|&&|\\|\\||\\.\\.|<|>|=|\\+|\\-|\\[|\\]|"
				+ "\"|\\(|\\)|\\{|\\}|\\:\\:|&|\\*|/|"
				+ patternPunct.replace(" ", "") + "| |\t|\n";

		Pattern pattern = Pattern.compile(patternSymb);
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

		for (int i = 0; i < arr.size() - 1; i++) {

			String temp = oldValue.substring(arr.get(i), arr.get(i + 1));
			if (temp.matches(patternSymb))
				add(new Punctuation(temp));
			else {
				if(temp.trim().length() > 0)
					add(new Word(temp.trim()));
			}	
		}
		
		trimPunctuation();
	}
	
	private void trimPunctuation() {
		for(int i = 0; i < size() - 1; i++) {
			Token curr = get(i);
			String val = curr.getOldValue();
			if(" ".equals(val) || "\t".equals(val) || "\n".equals(val)) {} else continue;
			
			if("\t".equals(val)) {
				val = " ";
				curr.setOldValue(val);
			}
			
			for(int j = i + 1; j < size(); j++) {
				if(val.equals(get(j).getOldValue())) {
					remove(j--);
				} else break;
			}
		}
		if(!isEmpty()) {
			if(!getFirst().isWord() && "\n".equals(getFirst().getOldValue()))
				removeFirst();
				
		}
	}
}
