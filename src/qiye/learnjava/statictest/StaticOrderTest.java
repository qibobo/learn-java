package qiye.learnjava.statictest;

public class StaticOrderTest {
	static{
		System.out.println("static block");
	}
	public static final int i = getInteger();
	{
		int j = 0;
	}
	public static int getInteger(){
		System.out.println("static method");
		return 100;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
