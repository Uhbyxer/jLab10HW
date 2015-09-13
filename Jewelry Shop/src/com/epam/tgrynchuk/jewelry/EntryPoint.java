package com.epam.tgrynchuk.jewelry;



import java.lang.reflect.Array;

import org.apache.log4j.Logger;

import com.epam.tgrynchuk.jewelry.mvc.engine.JewelryController;

/**
 * 		   @author Taras Grynchuk
 * 
 * 		   <br>
 *         <b>����� ����� � ��������</b><br>
 * 
 *         ��������� ��������:<br>
 *         <ul>
 *         <li><i>com.epam.tgrynchuk.jewelry.mvc.engine</i> - ����������
 *         ��������, (�����: JewelryController, Menu, ���������: MenuItem)</li>
 * 
 *         <li><i>com.epam.tgrynchuk.jewelry.mvc.models</i> - ������ ��������</li>
 * 
 *         <li><i>com.epam.tgrynchuk.jewelry.mvc.ui</i> - ��������������
 *         ��������� ��������, (�����: Window, ScannerSigleton)</li>
 *         </ul>
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

public class EntryPoint {
	private static final Logger LOGGER = Logger.getLogger(EntryPoint.class);

	public static void main(String[] args) {
		LOGGER.info("Starts......");
		JewelryController controller = new JewelryController();
		controller.start();
		
		

	}

}
