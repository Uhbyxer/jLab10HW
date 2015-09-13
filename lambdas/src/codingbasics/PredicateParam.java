package codingbasics;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateParam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Integer> nums = Arrays.asList(8,9,5,6,7,3,4,5,6);
		
		System.out.println("test 1");
		printFilter(nums, (x) -> (x > 5));
	
		System.out.println("test 2");
		printFilter(nums, (x) -> (true));
	
	}
	
	public static void printFilter(List<Integer> nums, Predicate<Integer> condition) {
		for(Integer num: nums) {
			if(condition.test(num)) {
				System.out.println(num);
			}
		}
	}

}
