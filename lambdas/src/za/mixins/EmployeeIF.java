package za.mixins;

public interface EmployeeIF {
	default void signIn() {
		System.out.println("signIn");
	}
	
	default void signOut() {
		System.out.println("signOut");
	}
}
