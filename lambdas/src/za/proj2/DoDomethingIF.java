package za.proj2;

@FunctionalInterface
public interface DoDomethingIF {
	public void doSomethin();
	public default void doSomeOther() {
		System.out.println("DoDomethingIF Some other");
	}
	public int hashCode();
	
	public boolean equals(Object obj);
	
}


