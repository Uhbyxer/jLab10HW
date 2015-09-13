package codingbasics;

public class Runables implements Runnable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Runnable r = new Runables();
		r.run();
		
		
		Runnable r2 = () -> System.out.println("Hello");
		r2.run();
	}

	@Override
	public void run() {
		System.out.println("old school");
		
	}

}
