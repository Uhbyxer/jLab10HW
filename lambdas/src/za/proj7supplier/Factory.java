package za.proj7supplier;

import java.util.function.Supplier;

public class Factory<X> {
	public X getShape(Supplier<? extends X> supplier) {
		
		X shape = supplier.get();
		
		System.out.println(shape + " created ");
		
		return shape;
		
	}
}
