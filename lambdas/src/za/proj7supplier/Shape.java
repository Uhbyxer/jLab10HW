package za.proj7supplier;

public interface Shape {
	void sketch();
}

class Rectangle implements Shape {

	@Override
	public void sketch() {
		System.out.println("Rect........");
		
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Rectangle";
	}
	
}

class Triangle implements Shape {

	@Override
	public void sketch() {
		
		System.out.println("Tri.........");
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Triangle";
	}
	
}

class Circle implements Shape {

	@Override
	public void sketch() {
		System.out.println("Circle.............");
		
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Circle";
	}
}
