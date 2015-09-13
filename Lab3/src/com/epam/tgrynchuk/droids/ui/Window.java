package com.epam.tgrynchuk.droids.ui;
import java.util.Collection;
import com.epam.tgrynchuk.droids.model.Army;
import com.epam.tgrynchuk.droids.model.Droid;

/**
 * @author Taras Grynchuk
 * 
 * <br><b>��������� ���� ��� �����/������</b><br>
 * 
 * @see com.epam.tgrynchuk.droids.ui.ScannerSigleton
 */
public class Window {
	private Army firstArmy, secondArmy;
	
	/**
	 * ����������� �� ���� �� ����� ���� �������
	 * @param firstArmy ���� 1-�� ������
	 * @param secondArmy ���� 2-�� ������
	 */
	public void init(Army firstArmy, Army secondArmy) {
		this.firstArmy = firstArmy;
		this.secondArmy = secondArmy;
		
		if(firstArmy == null || secondArmy == null) return;
		
		for(int i = 0; i < 50; i++) System.out.println("");
		
		System.out.println("Opponents:");
		System.out.println("1 Player: " + firstArmy);
		System.out.println("VS");
		System.out.println("2 Player: " + secondArmy);
		
		System.out.println("=================================================");
		System.out.println(firstArmy);
		System.out.println("Total costs: " + firstArmy.getValue() + " coins");
		System.out.println("-------------------------------------------------");
		for(Droid d: firstArmy) {
			System.out.println(d);
		}
		System.out.println();
		
		System.out.println("=================================================");
		System.out.println(secondArmy);
		System.out.println("Total costs: " + secondArmy.getValue() + " coins");
		System.out.println("-------------------------------------------------");
		for(Droid d: secondArmy) {
			System.out.println(d);
		}
		
	}

	/**
	 * �������� �� �����
	 * @param first 1-� ����
	 * @param second 2-� ����
	 */
	public void showAction(Droid first, Droid second) {
		if(second == null) {
			System.out.println(first.getName() + " is charging his blaster ...");
		} else if(Droid.AreDroidsFriends(first, second, firstArmy, secondArmy)) {
			System.out.println(first.getName() + " is repairing his friend: " + second.getName());
		} else {
			System.out.println(first.getName() + " shoots the enemy: " + second.getName());
			if(!second.isAlive()) 
				System.err.println("\n" + second.getName() + " is dead !!!\n");
		}
	}

	/**
	 * ������� ��������� ���
	 * @param message ����� �����������
	 * @param army ���� ���������
	 */
	public void showResults(String message, Army army) {
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println(message);
		System.out.println("Alive warriors:");
		for(Droid d: army.getAliveDroids()) System.out.println(d); 
		
	}

	/**
	 * ³��������� ����
	 * @param menu ����
	 * @return ��������� ������������ ������
	 */
	public String showMenu(Collection <? extends Object> menu) {
		System.out.println("\n========== Menu ==========");
		for(Object c: menu) 
			System.out.println(c);
		
		System.out.println("==========================");
		System.out.print("Enter your choise: ");
		return ScannerSigleton.readString();
	}
	
	/**
	 * ������� ����������� ��� �������
	 * @param message ����� �����������
	 */
	public void showError(String message) {
		System.out.println(message);
	}
}