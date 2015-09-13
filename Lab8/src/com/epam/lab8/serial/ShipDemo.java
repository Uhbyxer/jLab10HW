package com.epam.lab8.serial;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Random;

public class ShipDemo {

	public static void main(String[] args) {
		System.out.println("Battle ship:");
		Ship<Droid> battleShip = new Ship<>(new BattleDroid("Tom"), new RepairDroid("Sandra"));
		battleShip.put(new BattleDroid("George"));
		for(Droid d: battleShip) {
			d.setMemory(new Random().nextInt(100));
			d.setPower(new Random().nextInt(100));
			System.out.println(d);
			d.act();
			System.out.println("power: " + d.getPower());
			System.out.println("memory: " + d.getMemory());
		}
		
		serializeShip(battleShip);
		
		Ship<Droid> newShip = deserializeShip();
		for(Droid d: newShip) {
			System.out.println(d);
			d.act();
			System.out.println("power: " + d.getPower());
			System.out.println("memory: " + d.getMemory());
		}
		
	}
	
	public static void serializeShip(Ship<Droid> ship) {
		System.out.println("Serializeing......");
		try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(new File("ship.ser")))) {
			out.writeObject(ship);
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static Ship<Droid> deserializeShip() {
		System.out.println("==========================================================");
		System.out.println("Deserializeing......");
		
		Ship<Droid> ship = new Ship<>();
		
		try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(new File("ship.ser")))) {
			ship = (Ship<Droid>) in.readObject();
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
		
		return ship;
	}
	

	
	
	
}
