package za.proj1;

public class DoSomething implements DoDomethingIF, DoSometfingIF2{



	@Override
	public void doSomethin() {
		// TODO Auto-gesxsxnerated method stub
		System.out.println("ksjxkjsxk");
	}
	
	public  void doSomeOther() {
		System.out.println("doSomethin Some other");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		DoSomething dos = new DoSomething();
		dos.doSomethin();
		dos.doSomeOther();
		
		
	}

}
