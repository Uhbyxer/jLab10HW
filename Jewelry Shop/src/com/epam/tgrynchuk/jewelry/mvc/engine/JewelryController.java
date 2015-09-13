package com.epam.tgrynchuk.jewelry.mvc.engine;




import org.apache.log4j.Logger;

import com.epam.tgrynchuk.jewelry.exceptions.BaseJewelryException;
import com.epam.tgrynchuk.jewelry.mvc.engine.menus.*;
import com.epam.tgrynchuk.jewelry.mvc.engine.menus.items.BuyItem;
import com.epam.tgrynchuk.jewelry.mvc.engine.menus.items.ChooseClientItem;
import com.epam.tgrynchuk.jewelry.mvc.engine.menus.items.ClientsItem;
import com.epam.tgrynchuk.jewelry.mvc.engine.menus.items.OpenConsoleItem;
import com.epam.tgrynchuk.jewelry.mvc.engine.menus.items.QuitProgtramItem;
import com.epam.tgrynchuk.jewelry.mvc.engine.menus.items.StonesItem;
import com.epam.tgrynchuk.jewelry.mvc.models.*;
import com.epam.tgrynchuk.jewelry.mvc.ui.*;
import com.epam.tgrynchuk.jewelry.mvc.models.enums.*;

import static com.epam.tgrynchuk.jewelry.utils.TextFile.*;
/**
 * 		   @author Taras Grynchuk
 *         <b>Основний контроллер пограми</b>
 *         
 * @see com.epam.tgrynchuk.jewelry.mvc.models.Agate
 * @see com.epam.tgrynchuk.jewelry.mvc.models.Beryl
 * @see com.epam.tgrynchuk.jewelry.mvc.models.Client
 * @see com.epam.tgrynchuk.jewelry.mvc.models.Diamond
 * @see com.epam.tgrynchuk.jewelry.mvc.models.Emerald
 * @see com.epam.tgrynchuk.jewelry.mvc.models.ListOfClients
 * @see com.epam.tgrynchuk.jewelry.mvc.models.ListOfStones
 * @see com.epam.tgrynchuk.jewelry.mvc.models.PreciousStone
 * @see com.epam.tgrynchuk.jewelry.mvc.models.Ruby
 * @see com.epam.tgrynchuk.jewelry.mvc.models.Sapphire
 * @see com.epam.tgrynchuk.jewelry.mvc.models.SemiPreciousStone
 * @see com.epam.tgrynchuk.jewelry.mvc.models.Spinel
 * @see com.epam.tgrynchuk.jewelry.mvc.models.Stone
 * @see com.epam.tgrynchuk.jewelry.mvc.models.Topaz
 * @see com.epam.tgrynchuk.jewelry.mvc.models.Turquoise
 * @see com.epam.tgrynchuk.jewelry.mvc.models.Valuable
 * @see com.epam.tgrynchuk.jewelry.mvc.ui.ScannerSigleton
 * @see com.epam.tgrynchuk.jewelry.mvc.ui.Window   
 * 
 */

public class JewelryController {
	private static final Logger LOGGER = Logger.getLogger(JewelryController.class);
	
	private final Window window;
	private ListOfStones listOfStones;
	private ListOfStones bucketOfStones;
	private ListOfClients listOfClients;
	
	private Client currentClient = null;
	
	public JewelryController() {
		LOGGER.trace("JewelryController()-->");
		
		window = new Window();
		listOfStones = new ListOfStones();
		bucketOfStones = new ListOfStones();
		listOfClients = new ListOfClients();
		
		LOGGER.info("try openListOfStonesToFile" );
		
		//відкриваємо файл з каментями
		try {
			openListOfStonesToFile(listOfStones);
		} catch(BaseJewelryException e) {
			window.showError(e + "\n" + e.getCause());
			LOGGER.error(e);
		}
		
		LOGGER.info("try openListOfClientsToFile" );
		//відкриваємо файл з клієнтами
		try {
			openListOfClientsToFile(listOfClients);
		} catch(BaseJewelryException e) {
			window.showError(e + "\n" + e.getCause());
			LOGGER.error(e);
		}
		LOGGER.trace("<--JewelryController()");
	}
	
	public Window getWindow() {
		return window;
	}
	
	public ListOfStones getListOfStones() {
		return listOfStones;
	}
	
	public ListOfStones getBucketOfStones() {
		return bucketOfStones;
	}

	public ListOfClients getListOfClients() {
		return listOfClients;
	}
	
	public Client getCurrentClient() {
		return currentClient;
	}

	public void setCurrentClient(Client currentClient) {
		this.currentClient = currentClient;
	}

	/**
	 * Запуск контроллера
	 */
	public void start() {
		LOGGER.info("start()-->");
		//створюємо головне меню
		Menu mainMenu = new Menu(
				new StonesItem(this),
				new ClientsItem(this),
				new ChooseClientItem(this),
				new BuyItem(this),
				new OpenConsoleItem(this),
				new QuitProgtramItem()
	    );
		
		for(;;) {
			//key - клавіша, яку ввів користувач 
			String key = window.showMenu(mainMenu.getItems());
			//виконнання команди, згідно натиснутої клавіші
			LOGGER.debug("mainMenu.select " + key);
			mainMenu.select(key);
		}
	}
}
