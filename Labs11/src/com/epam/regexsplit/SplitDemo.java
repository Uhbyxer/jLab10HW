package com.epam.regexsplit;

import java.util.regex.Pattern;

public class SplitDemo {

	public static void main(String[] args) {
		
		String text = "one the two the three you find you next";
		String patternString = "the|you";
		Pattern pattern = Pattern.compile(patternString);
		String[] split = pattern.split(text);
        for(String element : split){
            System.out.println("element = " + element);
        }

	}

}
