package com.epam.lab7.droidqueue;

public class DroidQueueDemo {

	public static void main(String[] args) {
		
		Droid[] droids = new Droid[] {
				new Droid("Selina", 150, 100),
				new Droid("John", 50, 40),
				new BattleDroid("Alan", 125, 70),
				new Droid("Bob", 150, 50),
				new Droid("Nick", 200, 2),
				new BattleDroid("Josua", 130, 130)
				
		};
		
		DroidQueue<Droid> powerQueue = new DroidQueue<>(Droid.BY_POWER_AND_HEALTH);
		DroidQueue<Droid> nameQueue = new DroidQueue<>(Droid.BY_NAME);
		
		for(Droid droid: droids) {
			powerQueue.push(droid);
			nameQueue.push(droid);
		}
		
		System.out.println("======================================");
		System.out.println("Power and health queue:");
		Droid droid;
		while((droid = powerQueue.pop()) != null) {
			System.out.println(droid);
		}
		
		System.out.println("\n======================================");
		System.out.println("Name queue:");
		while((droid = nameQueue.pop()) != null) {
			System.out.println(droid);
		}

	}

}
