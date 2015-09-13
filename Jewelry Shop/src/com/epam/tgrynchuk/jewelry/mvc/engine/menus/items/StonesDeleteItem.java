package com.epam.tgrynchuk.jewelry.mvc.engine.menus.items;

import static com.epam.tgrynchuk.jewelry.utils.ClassInfo.getStoneClassCount;
import static com.epam.tgrynchuk.jewelry.utils.ClassInfo.getStoneClassNameByIndex;
import static com.epam.tgrynchuk.jewelry.utils.ClassInfo.getStoneClassNamesWithIndexes;
import static com.epam.tgrynchuk.jewelry.utils.Reflection.newInstanceOfStone;
import static com.epam.tgrynchuk.jewelry.utils.TextFile.saveListOfStonesToFile;

import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;

import com.epam.tgrynchuk.jewelry.exceptions.BaseJewelryException;
import com.epam.tgrynchuk.jewelry.mvc.engine.JewelryController;
import com.epam.tgrynchuk.jewelry.mvc.engine.menus.MenuItem;
import com.epam.tgrynchuk.jewelry.mvc.models.Stone;

public class StonesDeleteItem implements MenuItem {
	private static final Logger LOGGER = Logger.getLogger(StonesDeleteItem.class);
	
	private final JewelryController controller;
	
	public StonesDeleteItem(JewelryController controller) {
		this.controller = controller;
		
		LOGGER.trace("StonesDeleteItem()");
	}

	@Override
	public boolean execute() {
		LOGGER.debug("StonesDeleteItem()");
		
		if(controller.getListOfStones().isEmpty()) {
			controller.getWindow().showError("\n������ ������ ������ !");
			return false;
		}
		controller.getWindow().showCollection(controller.getListOfStones(), "\n������ ������:");
		
		Set<Integer> setOfId = new HashSet<>();
		for(Stone s: controller.getListOfStones()) 
			setOfId.add(s.getId());
		
		
	    int index = controller.getWindow().enterInt("\n������� ����� ������ ��� ���������: ", setOfId);
		
	    LOGGER.debug("try getListOfStones().getStoneById(index): " + index);
	    try {
	    	Stone stone = controller.getListOfStones().getStoneById(index);
	    	if(stone == null) 
	    		throw new BaseJewelryException("�������� ��������");
	    	controller.getListOfStones().remove(stone);
	    	LOGGER.info("getListOfStones().remove " + stone);
	    	
			saveListOfStonesToFile(this.controller.getListOfStones());
			LOGGER.info("saveListOfStonesToFile");
			
			controller.getWindow().showMessage("��������: \n" + stone.toString());
			
	    } catch(BaseJewelryException e) {
	    	controller.getWindow().showError(e + "\n" + e.getCause());
	    }
	    
	    return false;		
	}

	@Override
	public String getKey() {
		return "3";
	}
	
	@Override
	public String toString() {
		return getKey() + " --> �������� �����...";
	}
}
