package za.proj6func;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class FunctionalDemo<X,Y> {
	public List<Y> applyFunction(Function<X, Y> function1, List<X> list) {
		
		List<Y> ret = new ArrayList<Y>();
		
		
		/*
		for(Integer i: list) {
			ret.add( function.apply(i) );
		}
		*/
		
		list.forEach(x -> ret.add(function1.apply(x)));
		
		return ret;
		
	}
	
	
	public List<Y> applyFunctionThen(Function<X, Y> function1,Function<Y, Y> function2, List<X> list) {
		
		List<Y> ret = new ArrayList<Y>();

		list.forEach(x -> ret.add(function1.andThen(function2).apply(x)));
		
		return ret;
		
	}
	
	//compose !!!!!!!!!!!!!!

}
