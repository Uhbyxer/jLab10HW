package com.epam.lab7.droids;

public class ShipDemo {

	public static void main(String[] args) {
		System.out.println("Battle ship:");
		Ship<BattleDroid> battleShip = new Ship<>(new BattleDroid("Tom"), new FlyBattleDroid("Winston"));
		battleShip.put(new BattleDroid("George"));
		for(BattleDroid d: battleShip) {
			System.out.println(d);
			d.act();
		}
		battleShip.get(0);
		
		
		
		System.out.println("\nRepair ship:");
		Ship<RepairDroid> repairShip = new Ship<>(new RepairDroid("Sandra"), new FlyRepairDroid("Lisa"));
		for(RepairDroid d: repairShip) {
			System.out.println(d);
			d.act();
		}
		
		repairShip.get(0);
		
	}
	
}
