package za.mixins;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Person person = new Person();
		
		person.buyShares();
		person.sellShare();
		person.buySmth();
		((EmployeeIF) person).signIn();
		((EmployeeIF) person).signOut();

	}

}
