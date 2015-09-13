package codingbasics;

import java.util.*;

public class ArrayListStat {

	public static void main(String[] args) {
		List<Integer> nums = Arrays.asList(8,7,4,3,5,6,14,16);
		System.out.println("non lambda");
		Integer max = Integer.MIN_VALUE;
		Integer min = Integer.MAX_VALUE;
		int sum = 0;
		for(Integer i: nums) {
			if(i > max) max = i;
			if(i < min) min = i;
			
			sum += i;
		}
		float avarage = sum/nums.size();
		
		System.out.println("max = " + max);
		System.out.println("min = " + min);
		System.out.println("sum = " + sum);
		System.out.println("ave = " + avarage);
		
		
		
		System.out.println("lambda");
		IntSummaryStatistics stats = nums.stream().mapToInt(x -> x).summaryStatistics();
		System.out.println("max = " + stats.getMax());
		System.out.println("min = " + stats.getMin());
		System.out.println("sum = " + stats.getSum());
		System.out.println("ave = " + stats.getAverage());
	}

}
