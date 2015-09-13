package codingbasics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Comparators {

	public static void main(String[] args) {
		List<Player> players = new ArrayList<>();
		players.add(new Player("Sidney", "Crosby", 87));
		players.add(new Player("Evgenii", "Malkin", 71));
		players.add(new Player("Cris", "Letang", 58));
		players.add(new Player("Anze", "Kopitar", 26));
		
		
		
		ArrayList<Player> players2 = (ArrayList<Player>) ((ArrayList<Player>) players).clone();
		
		
		
		Comparator<Player> c1 = new Comparator<Player>() {

			@Override
			public int compare(Player o1, Player o2) {
				return o1.firstName.compareTo(o2.firstName);
			}
			
		};

		Collections.sort(players,c1);
		
		players.forEach(System.out::println);
		
		Comparator<Player> c2 = (Player p1, Player p2) -> p1.firstName.compareTo(p2.firstName);
		System.out.println("================================================");
		players2.stream().sorted(c2).forEach(System.out::println);
	}

}
