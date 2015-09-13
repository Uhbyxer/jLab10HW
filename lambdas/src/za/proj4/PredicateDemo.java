package za.proj4;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PredicateDemo<T> {
	public  List<T> testPredicate(Predicate<T> p, List<T> list) {
		List<T> ret = new ArrayList<T>();
		
		for(T i: list) {
			if (p.test(i))
				ret.add(i);
		}
		
		return ret;
		
	}
	
	public  List<T> testPredicateNegate(Predicate<T> p, List<T> list) {
		List<T> ret = new ArrayList<T>();
		
		for(T i: list) {
			if (p.negate().test(i))
				ret.add(i);
		}
		
		return ret;
		
	}	
	
	
	public  List<T> testPredicateOr(Predicate<T> p, Predicate<T> other, List<T> list) {
		List<T> ret = new ArrayList<T>();
		
		for(T i: list) {
			if (p.or(other).test(i))
				ret.add(i);
		}
		
		return ret;
		
	}	
}
