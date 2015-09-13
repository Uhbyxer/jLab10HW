package za.proj7supplier;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		
		Factory<Shape> factory = new Factory<>();
		Shape circle = factory.getShape(()-> new Circle());
		circle.sketch();
		
		Factory<Vehicle> veh = new Factory<Vehicle>();
		Vehicle car = veh.getShape(()->new Car());
		car.operate();
	}

}
