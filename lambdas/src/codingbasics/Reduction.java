package codingbasics;

import java.util.ArrayList;
import java.util.List;

public class Reduction {

	public static void main(String[] args) {
		List<Integer> nums = new ArrayList<>();
		nums.add(3);
		nums.add(9);
		nums.add(2);
		nums.add(10);
		
		int total = 0;
		for(int i: nums) total += i;
		System.out.println(total);
		
		int sum = nums.stream().reduce(0, (a, b) -> a + b);
		System.out.println(sum);
	}

}
