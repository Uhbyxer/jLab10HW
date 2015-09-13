package codingbasics;

import java.util.*;



public class MethodReference {
	public static void main(String[] args) {
		List<String> letters =  Arrays.asList("a", "b","c","d","e","f", "g", "h", "i","j");
		
		long start2 = System.currentTimeMillis();
		letters.stream().forEach(System.out::println);
		long end2 = System.currentTimeMillis();
		System.out.println(end2 - start2);
		
		
		long start = System.currentTimeMillis();
		letters.stream().forEach(x -> System.out.println(x));
		long end = System.currentTimeMillis();
		System.out.println(end - start);
		
		

		
	}
}
