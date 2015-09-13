package codingbasics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorsClass {

	public static void main(String[] args) {
		List<String> letters = Arrays.asList("a", "b", "c", "d", "e","f");
		List<String> names = Arrays.asList("Adam", "Brent", "Andrew", "Carl", "Doug","Alex");

		String concat = "";
		for(String l: letters) {
			concat += l;
		}
		System.out.println(concat);
		
		String con = letters.stream().collect(Collectors.joining("|"));
		System.out.println(con);
		
		
		List<String> namesA = new ArrayList<String>();
		for(String n: names) {
			if(n.startsWith("A")) {
				namesA.add(n);
			}
		}
		System.out.println(namesA);
			
		
		List<String> nameslam = names.stream().filter(x -> x.startsWith("A")).collect(Collectors.toList());
		System.out.println(nameslam);
		
	}

}
