package codingbasics;

public class Threads {

	public static void main(String[] args) {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("Tread ready oldschool");
				
			}
		}).start();;
		
		
		
		new Thread(() -> System.out.println("new way")).start();
		
	}

}
