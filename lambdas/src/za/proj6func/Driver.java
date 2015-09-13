package za.proj6func;

import java.util.Arrays;
import java.util.List;

public class Driver {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(0,1,2,3,4,5);
		
		FunctionalDemo<Integer, Double> func = new FunctionalDemo<>();
		System.out.println("x as Double : " + func.applyFunction(x -> new Double(x), list));
		System.out.println("0.5 * x : " + func.applyFunction(x -> 0.5*x, list));
		
		
		
		System.out.println("x then : " + func.applyFunctionThen(
				x -> new Double(x*x)
			,   x -> (x+x)
		, list));
	}

}
