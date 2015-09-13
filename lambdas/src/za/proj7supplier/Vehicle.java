package za.proj7supplier;

public interface Vehicle {
	void operate();
}

class Car implements Vehicle{

	@Override
	public void operate() {
		System.out.println("operate car");
		
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Car";
	}
	
}

class Truck implements Vehicle{

	@Override
	public void operate() {
		System.out.println("operate truck");
		
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Truck";
	}
	
}
