package codingbasics;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Filtering {

	public static void main(String[] args) {
		List<Integer> nums = new ArrayList<>();
		nums.add(3);
		nums.add(9);
		nums.add(2);
		nums.add(10);

		List<Integer> filtered = new ArrayList<>();
		for(Integer i: nums) {
			if(i%2 == 0)
				filtered.add(i);
		}
		System.out.println(filtered);
		
		

		
		

		List<Integer> filter2 = nums.stream().filter(x -> x%2 == 0).collect(Collectors.toList());
		System.out.println(filter2);
		
		Predicate<Integer> odd = (x) -> (x%2 != 0);
		List<Integer> filter3 = nums.stream().filter(odd).collect(Collectors.toList());
		System.out.println(filter3);
	}

}
