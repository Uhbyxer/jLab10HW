package com.epam.tgrynchuk.jewelry.mvc.engine.menus.items;

import static com.epam.tgrynchuk.jewelry.utils.TextFile.saveListOfClientsToFile;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;

import com.epam.tgrynchuk.jewelry.exceptions.BaseJewelryException;
import com.epam.tgrynchuk.jewelry.mvc.engine.JewelryController;
import com.epam.tgrynchuk.jewelry.mvc.engine.menus.MenuItem;
import com.epam.tgrynchuk.jewelry.mvc.models.Client;
import com.epam.tgrynchuk.jewelry.mvc.models.Stone;
import com.epam.tgrynchuk.jewelry.mvc.models.enums.StoneTransparency;

public class FindStonesInTransparencyRange implements MenuItem {
	private static final Logger LOGGER = Logger.getLogger(FindStonesInTransparencyRange.class);
	
	private final JewelryController controller;
	
	public FindStonesInTransparencyRange(JewelryController controller) {
		this.controller = controller;
		
		LOGGER.trace("FindStonesInTransparencyRange()");
	}

	@Override
	public boolean execute() {
		LOGGER.debug("FindStonesInTransparencyRange.execute()");
		
		if(controller.getBucketOfStones().isEmpty()) {
			controller.getWindow().showError("\nКошик пустий !");
			return false;
		}
		controller.getWindow().showMessage("\nПараметри прозорості:");
		Set<Integer> setOfId = new HashSet<>();

		
		for(StoneTransparency t: StoneTransparency.values()) {
			controller.getWindow().showMessage("" + t.getIndex() + ". " + t.toString());
			setOfId.add(t.getIndex());			
		}
		
		
	    int from = controller.getWindow().enterInt("\nПочаток інтервалу: ", setOfId);
	    int to = controller.getWindow().enterInt("\nКінець інтервалу: ", setOfId);
	    
	    if(from > to) {
	    	controller.getWindow().showError("\nНе правильний інтервал !");
	    	return false;
	    }
	    
	    List<Stone> res = controller.getBucketOfStones().getByRangeOfTransparency(from, to);
	    if(res.isEmpty()) 
	    	controller.getWindow().showMessage("\nНічого не знайдено !");
	    else
	    	controller.getWindow().showCollection(res, "\nСписок знайдених каменів:");
	    
	    return false;		
	}

	@Override
	public String getKey() {
		return "6";
	}
	
	@Override
	public String toString() {
		return getKey() + " --> Знайти камені в діапазоні прозорості";
	}
}
