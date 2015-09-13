package com.epam.tgrynchuk.jewelry.utils;

import java.util.*;

public class ClassInfo {
	
	private static List<String> holderEn, holderUa;
	private static String classNamesWithIndexes;
	static {
		holderEn = new ArrayList<>(Arrays.asList("Agate Beryl Diamond Emerald Ruby Sapphire Spinel Topaz Turquoise".split(" ")));
		holderUa = new ArrayList<>(Arrays.asList("Агат Берил Алмаз Смарагд Рубін Сапфір Шпінель Топаз Бірюза".split(" ")));
		
		classNamesWithIndexes = "";
		int i = 0;
		for(String str: holderUa)
			classNamesWithIndexes += str + "=" + i++ + "; ";
	}
	
	public static String getStoneClassNameByIndex(int index) {
		return holderEn.get(index);
	}
	
	public static String getStoneStringNameByIndex(int index) {
		return holderUa.get(index);
	}
	
	public static String getStoneClassNamesWithIndexes() {
		return classNamesWithIndexes;
	}
	
	public static int getStoneClassCount() {
		return holderEn.size();
	}
}
