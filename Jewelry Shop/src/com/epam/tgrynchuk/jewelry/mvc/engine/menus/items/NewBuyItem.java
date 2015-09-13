package com.epam.tgrynchuk.jewelry.mvc.engine.menus.items;

import static com.epam.tgrynchuk.jewelry.utils.TextFile.saveListOfStonesToFile;

import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;

import com.epam.tgrynchuk.jewelry.exceptions.BaseJewelryException;
import com.epam.tgrynchuk.jewelry.mvc.engine.JewelryController;
import com.epam.tgrynchuk.jewelry.mvc.engine.menus.MenuItem;
import com.epam.tgrynchuk.jewelry.mvc.models.Stone;

public class NewBuyItem implements MenuItem {
	private static final Logger LOGGER = Logger.getLogger(NewBuyItem.class);
	
	private final JewelryController controller;
	
	public NewBuyItem(JewelryController controller) {
		this.controller = controller;
		
		LOGGER.trace("NewBuyItem()");
	}

	@Override
	public boolean execute() {
		LOGGER.debug("NewBuyItem.execute()");
		
		if(controller.getListOfStones().isEmpty()) {
			controller.getWindow().showError("\n������ ������ ������ !");
			return false;
		}
		if(controller.getCurrentClient() == null) {
			controller.getWindow().showError("\n�� ������� �볺��� !");
			return false;
		}
		
		LOGGER.debug("getBucketOfStones().clear()");
		controller.getBucketOfStones().clear();
		controller.getWindow().showCollection(controller.getListOfStones(), "\n������ ������:");
		
		Set<Integer> setOfId = new HashSet<>();
		for(Stone s: controller.getListOfStones()) 
			setOfId.add(s.getId());
		
		setOfId.add(-1);
		
		for (;;) {

			int index = controller.getWindow().enterInt(
					"\n������� ����� ������: "
							+ "(-1 --> ��������� �������): ", setOfId);

			if (index == -1) {
				controller.getWindow().showMessage("������� ��������� !");
				controller.getWindow().showMessage(
						"�������� ����: "
								+ controller.getBucketOfStones().getWeight());
				controller.getWindow().showMessage(
						"�������� �������: "
								+ controller.getBucketOfStones().getValue());
				break;
			}

			try {
				Stone stone = controller.getListOfStones().getStoneById(index);
				if (stone == null)
					throw new BaseJewelryException("�������� ��������");

				controller.getBucketOfStones().add(stone);
				LOGGER.info("getBucketOfStones().add(stone)");

				controller.getWindow().showMessage(
						"������ � �����: \n" + stone.toString());
				controller.getWindow().showMessage("-----------------------------------------------------");
				controller.getWindow().showMessage(stone.promote(controller.getCurrentClient()));
				controller.getWindow().showMessage("-----------------------------------------------------");

			} catch (BaseJewelryException e) {
				controller.getWindow().showError(e + "\n" + e.getCause());
			}
		}
	    
	    return false;		
	}

	@Override
	public String getKey() {
		return "1";
	}
	
	@Override
	public String toString() {
		return getKey() + " --> ���� �������...";
	}
}
