package lambdas;
import java.util.*;


public class TestLambdas {

	public static void main(String[] args) {
		List features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API"); 
		features.forEach(n -> System.out.println(n));
		
		System.out.println("============================");
		features.forEach(System.out::println);

	}

}



//http://javarevisited.blogspot.com/2014/02/10-example-of-lambda-expressions-in-java8.html
