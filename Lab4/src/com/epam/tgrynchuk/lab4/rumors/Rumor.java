package com.epam.tgrynchuk.lab4.rumors;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;

import com.epam.tgrynchuk.lab4.ScannerSigleton;

public class Rumor {

	public static void main(String[] args) {
		
		System.out.println("Enter Count of quests:");
		int n = ScannerSigleton.readInt();
		if (n < 3) {
			System.err.println("Error! count of quests < 3 !");
			return;
		}		
				
		System.out.println("Enter count of experiments:");
		int experimentCount = ScannerSigleton.readInt();
		if(experimentCount < 1) {
			System.err.println("Error! Count of experiments < 1 !");
			return;
		}
		

		int[] arr = new int[n + 1]; 
		Arrays.fill(arr, 0);
		
		for(int e = 1; e <= experimentCount; e++) {
			//System.out.println("======================================================================================");
			//System.out.println("Experiment # " + e);
			
			LinkedList<Guest> allGuests = new LinkedList<>();
			for (int i = 0; i < n; i++) {
				if (i == 0)
					allGuests.add(new Guest("Bob"));
				else
					allGuests.add(new Guest("Guest" + i));
			}

			LinkedList<Guest> proccesedGuests = new LinkedList<>();

			Guest sourceGuest = null;
			Guest destinationGuest = null;
			Guest currentGuest = allGuests.getFirst();

			// поки ще не всі опрацьовані (почули чутки)
			while (!proccesedGuests.containsAll(allGuests)) {

				// з кого будемо вибирати
				LinkedList<Guest> choiceGuests = new LinkedList<>(allGuests);
				// за виключенням того хто нам сказав і нас
				if (sourceGuest != null)
					choiceGuests.remove(sourceGuest);
				choiceGuests.remove(currentGuest);

				// Рендомно отримаємо гостя, якому розкажемо чутку
				destinationGuest = choiceGuests.get(new Random()
						.nextInt(choiceGuests.size()));

				// якщо почув чутку вдруге
				if (proccesedGuests.contains(destinationGuest))
					break;

				proccesedGuests.add(destinationGuest);

				// буде розказувати наступний
				sourceGuest = currentGuest;
				currentGuest = destinationGuest;

			}
			if (proccesedGuests.containsAll(allGuests)) {
				//System.out.println("All guests were informated !!!");
				//System.out.println(Arrays.toString(proccesedGuests.toArray()));
			} else {
				//System.out.println(Arrays.toString(proccesedGuests.toArray())
				//		+ " ... " + destinationGuest);
			}
			//System.out.println("Informed guests: " + proccesedGuests.size());	
			
			arr[proccesedGuests.size()]++;
		}
		
		System.out.println("\n**********************************************************************************");
		System.out.println("Total:");
		System.out.println(Arrays.toString(arr));
		System.out.println("Everyone probability: " + arr[arr.length-1] + " from " + experimentCount + " = " + (100 * arr[arr.length-1] / experimentCount) + " %");
	
		LinkedList<ElementOfArray> sortedProbability = new LinkedList<>();
		for(int k = 0; k < arr.length; k++) {
			sortedProbability.add(new ElementOfArray(k, arr[k]));
		}
		Collections.sort(sortedProbability);
		for(ElementOfArray p: sortedProbability) {
			if(p.getValue() == 0) break;
			
			System.out.println("" + p.getIndex() + " guests probability: " + p.getValue()  + " from " + experimentCount + " = " + (100 * p.getValue() / experimentCount) + " %");
			
		}
	}

}
