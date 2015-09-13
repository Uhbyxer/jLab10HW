package com.epam.lab6.comparators;

import java.util.Iterator;
import java.util.Random;

public class CountryGenerator implements Iterable<Country> {

	private int size;
	
	public CountryGenerator(int size) {
		super();
		this.size = size;
	}
	
	@Override
	public Iterator<Country> iterator() {
		return new Iterator<Country>() {
			int count = 0;

			@Override
			public boolean hasNext() {
				return count < size;
			}

			@Override
			public Country next() {
				count++;
				
				int i = new Random().nextInt(COUNTRIES.length);
				
				String[] temp = COUNTRIES[i].split(":");
				
				return new Country(temp[0], temp[1]);
			}
		};
	}
	
	private static final String[] 
			COUNTRIES = ("United Arab Emirates:Abu Dhabi#"
					+ "Nigeria:Abuja#"
					+ "Ghana:Accra#"
					+ "Pitcairn Islands:Adamstown#"
					+ "Ethiopia:Addis Ababa#"
					+ "Algeria:Algiers#"
					+ "Niue:Alofi#"
					+ "Jordan:Amman#"
					+ "Netherlands:Amsterdam#"
					+ "Andorra:Andorra la Vella#"
					+ "Turkey:Ankara#"
					+ "Madagascar:Antananarivo#"
					+ "Samoa:Apia#"
					+ "Turkmenistan:Ashgabat#"
					+ "Eritrea:Asmara#"
					+ "Kazakhstan:Astana#"
					+ "Paraguay:Asunción#"
					+ "Greece:Athens#"
					+ "Cook Islands:Avarua#"
					+ "Iraq:Baghdad#"
					+ "Azerbaijan:Baku#"
					+ "Mali:Bamako#"
					+ "Peru:Lima#"
					+ "Zambia:Lusaka#"
					+ "Luxembourg:Luxembourg#"
					+ "Kenya:Nairobi#"
					+ "Bahamas:Nassau#"
					+ "Norway:Oslo#"
					+ "Panama:Panama City#"
					+ "Morocco:Rabat#"
					+ "Italy:Rome#"
					+ "Ukraine:Kyiv#"
					+ "Bulgaria:Sofia#"
					+ "Bolivia:Sucre#"
					+ "Abkhazia:Sukhumi#"
					+ "Georgia:Tbilisi#"
					+ "Albania:Tirana#"
					+ "Thailand:Bangkok").split("#"); 

	
}
