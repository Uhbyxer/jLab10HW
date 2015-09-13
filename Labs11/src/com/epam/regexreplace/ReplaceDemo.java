package com.epam.regexreplace;

import java.util.regex.Pattern;

public class ReplaceDemo {

	public static void main(String[] args) {
	      String text    =
	                "John writes about this, and John Doe writes about that," +
	                        " and John Wayne writes about everything."
	              ;

	      String patternString1 = "a|e|y|u|i|o|j";
	      patternString1 += "|"  + patternString1.toUpperCase();

	      Pattern pattern = Pattern.compile(patternString1);
	      java.util.regex.Matcher matcher = pattern.matcher(text);

	      String replaceAll = matcher.replaceAll("_");
	      System.out.println("replaceAll   = " + replaceAll);


	}

}
