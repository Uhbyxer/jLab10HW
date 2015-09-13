package za.proj1;

public interface DoSometfingIF2 {
	public void doSomethin();
	public default void doSomeOther() {
		System.out.println("DoDomethingIF2 Some other");
	}
}
