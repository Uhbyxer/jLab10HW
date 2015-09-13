package com.epam.tgrynchuk.jewelry.utils;

import java.io.*;

import org.apache.log4j.Logger;

import com.epam.tgrynchuk.jewelry.exceptions.ClientNewInstanceException;
import com.epam.tgrynchuk.jewelry.exceptions.ClientOpeningException;
import com.epam.tgrynchuk.jewelry.exceptions.ClientSavingException;
import com.epam.tgrynchuk.jewelry.exceptions.StoneNewInstanceException;
import com.epam.tgrynchuk.jewelry.exceptions.StoneOpeningException;
import com.epam.tgrynchuk.jewelry.exceptions.StoneSavingException;
import com.epam.tgrynchuk.jewelry.mvc.models.Client;
import com.epam.tgrynchuk.jewelry.mvc.models.ListOfClients;
import com.epam.tgrynchuk.jewelry.mvc.models.ListOfStones;
import com.epam.tgrynchuk.jewelry.mvc.models.Stone;

import static com.epam.tgrynchuk.jewelry.utils.Reflection.*;

public class TextFile {
	private static final Logger LOGGER = Logger.getLogger(TextFile.class);
	
	public static void saveListOfStonesToFile(ListOfStones list) {
		LOGGER.trace("saveListOfStonesToFile-->");
		
		try (PrintStream out = new PrintStream(new FileOutputStream(".\\Files\\Goods.txt"))) {
		    
			for(Stone s: list)
		    	out.println(s.getClass().getSimpleName() + " " + s.getId() 
		    			+ " " + s.getValue() + " " + s.getWeight());
		
		} catch (FileNotFoundException  e) {
			throw new StoneSavingException("Помилка збереження списку каменів", e);
		}
	}
	
	public static void openListOfStonesToFile(ListOfStones list) {
		LOGGER.trace("openListOfStonesToFile-->");
		
		if(!list.isEmpty())
			list.clear();
		
		try (BufferedReader in = new BufferedReader(new FileReader(new File(".\\Files\\Goods.txt")))) {
			String s;
			
			while((s = in.readLine()) != null) {
				String[] a = s.split(" ");
				list.add(
						newInstanceOfStone("com.epam.tgrynchuk.jewelry.mvc.models." + a[0], 
								Integer.parseInt(a[1]), Double.parseDouble(a[2]) , Double.parseDouble(a[3]))
				);		
			}
		} catch(FileNotFoundException e) {
			//файлу може спочатку і не бути
		} catch (IOException | NumberFormatException | ArrayIndexOutOfBoundsException | StoneNewInstanceException  e) {
			throw new StoneOpeningException("Помилка відкриття списку каменів", e);
		}
		
	}
	
	public static void saveListOfClientsToFile(ListOfClients list) {
		
		try (PrintStream out = new PrintStream(new FileOutputStream(".\\Files\\Clients.txt"))) {
		    
			for(Client s: list)
		    	out.println(s.getName() + " " + s.getAge() + " " + (s.isMale() ? "1" : "0"));
		
		} catch (FileNotFoundException  e) {
			throw new ClientSavingException("Помилка збереження списку клієнтів", e);
		}
	}
	
	public static void openListOfClientsToFile(ListOfClients list) {
		
		if(!list.isEmpty())
			list.clear();
		
		try (BufferedReader in = new BufferedReader(new FileReader(new File(".\\Files\\Clients.txt")))) {
			String s;
			
			while((s = in.readLine()) != null) {
				String[] a = s.split(" ");
				list.add(
						newInstanceOfClient(a[0], Integer.parseInt(a[1]), "1".equals(a[2]) ? true : false)
				);		
			}
		} catch(FileNotFoundException e) {
			//файлу може спочатку і не бути
		} catch (IOException | NumberFormatException | ArrayIndexOutOfBoundsException | ClientNewInstanceException  e) {
			throw new ClientOpeningException("Помилка відкриття списку клієнтів", e);
		}
		
	}
}
