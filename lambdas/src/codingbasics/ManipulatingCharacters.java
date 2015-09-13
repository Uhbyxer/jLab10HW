package codingbasics;

public class ManipulatingCharacters {

	public static void main(String[] args) {
		String random = "wjhjwhdk4wdkwxlwxl7mlefl8kejfhelfhelcelcwc";
		for(int i = 0; i < random.length(); i++) {
			if(Character.isDigit(random.charAt(i))) {
				System.out.println(random.charAt(i));
			}
		}
		
		
		random.chars().filter(Character::isDigit).map(Character::getNumericValue).forEach(System.out::println);
		
	}

}
