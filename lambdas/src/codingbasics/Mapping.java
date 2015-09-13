package codingbasics;

import java.util.ArrayList;
import java.util.List;

public class Mapping {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Player> players = new ArrayList<>();
		players.add(new Player("Sidney", "Crosby", 87));
		players.add(new Player("Evgenii", "Malkin", 71));
		players.add(new Player("Cris", "Letang", 58));
		players.add(new Player("Anze", "Kopitar", 26));
		
		System.out.println("Non lambda");
		for(Player p: players) {
			System.out.println("#" + p.number );
		}
		
		System.out.println("\nLambda");
		players.stream().mapToInt(x -> x.number).forEach(System.out::println);
	}

}

class Player {
	public String firstName;
	public String lastName;
	public int number;
	public Player(String firstName, String lastName, int number) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.number = number;
	}
	@Override
	public String toString() {
		return "Player [firstName=" + firstName + ", lastName=" + lastName
				+ ", number=" + number + "]";
	}
	
	
}
