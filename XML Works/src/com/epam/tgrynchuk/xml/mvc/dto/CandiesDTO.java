package com.epam.tgrynchuk.xml.mvc.dto;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "candies")
public class CandiesDTO {
	private List<CandyDTO> candies = new ArrayList<>();
	
	public CandiesDTO() {
		// TODO Auto-generated constructor stub
	}

	@XmlElement( name = "candy" ) 
	public List<CandyDTO> getCandies() {
		return candies;
	}

	public void setCandies(List<CandyDTO> candies) {
		this.candies = candies;
	}
	
	public void add(CandyDTO candy) {
		candies.add(candy);
	}
	
	@Override
	public String toString() {
		return candies.toString();
	}
	
}
