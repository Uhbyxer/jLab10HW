package za.proj4;

import java.util.Arrays;
import java.util.List;

public class Driver {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(0,1,2,3,4,5);
		List<String> strList = Arrays.asList("one two three four five six seven eight".split(" "));
		List<Object> objList = Arrays.asList(new Object(), new String("two"), new StringBuilder("three"));
		
		PredicateDemo<Integer> predInt = new PredicateDemo<>();
		System.out.println("all #s:" + predInt.testPredicate(x -> true, list));
		System.out.println("all even: " + predInt.testPredicate(x -> (x&1)==0, list)  );
		System.out.println("all odd: " + predInt.testPredicate(x -> (x&1)!=0, list)  );
		
		System.out.println("---------------------------------------------");
		PredicateDemo<String> predStr = new PredicateDemo<>();
		System.out.println("all strings:" + predStr.testPredicate(x -> true, strList));
		System.out.println("contains ee:" + predStr.testPredicate(x -> x.contains("ee"), strList));
		System.out.println("contains t:" + predStr.testPredicate(x -> x.contains("t"), strList));
		
		System.out.println("---------------------------------------------");
		PredicateDemo<Object> predObj = new PredicateDemo<>();
		System.out.println("all strings:" + predObj.testPredicate(x -> true, objList));
		System.out.println("contains ee:" + predObj.testPredicate(x -> x instanceof String, objList));
		System.out.println("contains t:" + predObj.testPredicate(x -> x instanceof StringBuilder, objList));
		
		System.out.println("Negate str---------------------------------------------");
		predStr = new PredicateDemo<>();
		System.out.println("all strings:" + predStr.testPredicateNegate(x -> true, strList));
		System.out.println("contains ee:" + predStr.testPredicateNegate(x -> x.contains("ee"), strList));
		System.out.println("contains t:" + predStr.testPredicateNegate(x -> x.contains("t"), strList));
		
		System.out.println("OR---------------------------------------------");
		predObj = new PredicateDemo<>();

		System.out.println("contains t:" + predObj.testPredicateOr(x -> x instanceof StringBuilder,
				x -> x instanceof String, objList));
		
	}

}
