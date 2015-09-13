package com.epam.tgrynchuk.jewelry.mvc.engine.menus.items;

import static com.epam.tgrynchuk.jewelry.utils.TextFile.*;

import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;

import com.epam.tgrynchuk.jewelry.exceptions.BaseJewelryException;
import com.epam.tgrynchuk.jewelry.mvc.engine.JewelryController;
import com.epam.tgrynchuk.jewelry.mvc.engine.menus.MenuItem;
import com.epam.tgrynchuk.jewelry.mvc.models.Client;


public class ClientsDeleteItem implements MenuItem {
	private static final Logger LOGGER = Logger.getLogger(ClientsDeleteItem.class);
	
	private final JewelryController controller;
	
	public ClientsDeleteItem(JewelryController controller) {
		this.controller = controller;
		
		LOGGER.trace("ClientsDeleteItem()");
	}

	@Override
	public boolean execute() {
		LOGGER.debug("JewelryController.execute()");
		
		if(controller.getListOfClients().isEmpty()) {
			controller.getWindow().showError("\n������ �볺��� ������ !");
			return false;
		}
		//controller.getWindow().showCollection(controller.getListOfStones(), "\n������ �볺���:");
		controller.getWindow().showMessage("\n������ �볺���:");
		Set<Integer> setOfId = new HashSet<>();

		for(int i = 0; i < controller.getListOfClients().size(); i++) {
			controller.getWindow().showMessage("" + i + ". " + controller.getListOfClients().get(i));
			setOfId.add(i);
		}
		
	    int index = controller.getWindow().enterInt("\n������� ����� �볺��� ��� ���������: ", setOfId);
		
	    LOGGER.debug("try getListOfClients().get(index)");
	    try {
	    	Client cl = controller.getListOfClients().get(index);
	    	if(cl == null) 
	    		throw new BaseJewelryException("�������� ��������");
	    	controller.getListOfClients().remove(cl);
	    	LOGGER.info("getListOfClients().remove " + cl);
	    	
			saveListOfClientsToFile(this.controller.getListOfClients());
			LOGGER.info("saveListOfClientsToFile");
			
			controller.getWindow().showMessage("��������: \n" + cl.toString());
			
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
		return getKey() + " --> �������� �볺���...";
	}
}
