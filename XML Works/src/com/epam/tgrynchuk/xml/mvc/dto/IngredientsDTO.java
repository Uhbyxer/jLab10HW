package com.epam.tgrynchuk.xml.mvc.dto;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.epam.tgrynchuk.xml.mvc.models.Candies;
import com.epam.tgrynchuk.xml.mvc.models.Candy;
import com.epam.tgrynchuk.xml.mvc.models.Ingredient;


@XmlRootElement(name = "ingredients")
public class IngredientsDTO {
	private List<IngredientDTO> ingregients;

	public IngredientsDTO() {
		// TODO Auto-generated constructor stub
	}
	
	@XmlElement( name = "ingredient" ) 
	public List<IngredientDTO> getIngregients() {
		return ingregients;
	}

	public void setIngregients(List<IngredientDTO> ingregients) {
		this.ingregients = ingregients;
	}
	
	@Override
	public String toString() {
		return ingregients.toString();
	}
	
	public void sort() {
		Collections.sort(ingregients, IngredientDTO.BY_NAME);
	}
	
	public IngredientsDTO(Candies candies) {
		ingregients = new ArrayList<>();
		
		Map<IngredientDTO, Integer> map = new HashMap<IngredientDTO, Integer>();
		
		for(Candy candy: candies) {
			for(Map.Entry<Ingredient, Integer> ingr: candy.entrySet()) {
				IngredientDTO temp = new IngredientDTO(ingr.getKey().getName(), ingr.getValue());
				
				Integer oldValue = map.getOrDefault(temp, 0);
				
				map.put(temp, oldValue + temp.getAmount());
			}
		}
		
		for(Map.Entry<IngredientDTO, Integer> ingr: map.entrySet()) {
			IngredientDTO temp = ingr.getKey();
			temp.setAmount(ingr.getValue());
			
			
			//add Candies
			for(Candy candy: candies) {
				for(Map.Entry<Ingredient, Integer> entry: candy.entrySet()) {
					Ingredient oldIngr = entry.getKey();
					
					if(oldIngr.getName().equals(temp.getName())) {
						temp.addCandy(new CandyDTO(candy));
					}
					
				}
			}
			
			ingregients.add(temp);
		}
		
	}

	
	public static IngredientsDTO getAllIngredients(Candies candies, File file) {
		IngredientsDTO dto = new IngredientsDTO(candies);
		dto.sort();

		/* init jaxb marshaler */
		JAXBContext jaxbContext;
		try {
			jaxbContext = JAXBContext.newInstance(IngredientsDTO.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			jaxbMarshaller.marshal(dto, file);
			
			//jaxbMarshaller.marshal(dto, System.out);

		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			return null;
		}
		
		return dto;
	}

}
