package codingbasics;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class Functions {

	public static void main(String[] args) {
		List<Player> players = new ArrayList<>();
		players.add(new Player("Sidney", "Crosby", 87));
		players.add(new Player("Evgenii", "Malkin", 71));
		players.add(new Player("Cris", "Letang", 58));
		players.add(new Player("Anze", "Kopitar", 26));
		
		Predicate<Player> startsWithA = player -> player.firstName.startsWith("A");
		Function<String, Predicate<Player>> startsWithLetter = letter -> player -> player.firstName.startsWith(letter);

		players.stream().filter(startsWithLetter.apply("A")).forEach(x -> System.out.println(x.firstName));;
		
		Function<Player, Integer> mapIt = player -> player.number;
		players.stream().map(x -> mapIt.apply(x)).forEach(System.out::println);
		
	}

}
