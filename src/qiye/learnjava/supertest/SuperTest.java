package qiye.learnjava.supertest;
class Base{
	public Base() {
		System.out.println("base constructor with no parameter");
	}
	public Base(String str) {
		System.out.println("base constructor with 1 parameter :" + str);
	}
}
class Sub extends Base{
//	public Sub() {
//		try {
//			super();//error: Constructor call must be the first statement in a constructor
//		}catch(Exception e) {}
//	}
	public Sub() {
//		super("111");
	}
}
public class SuperTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Sub();
	}

}
