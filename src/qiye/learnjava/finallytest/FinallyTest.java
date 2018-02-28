package qiye.learnjava.finallytest;
class Person{
	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Person(String name) {
		super();
		this.name = name;
	}

	public String toString() {
		return "person name:" + this.name;
	}
}
public class FinallyTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(method1());
		System.out.println(method2());
		System.out.println(method3());
	}

	@SuppressWarnings("finally")
	public static int method1() {
		try {
			throw new RuntimeException();
		} finally {
			return 1;
		}
	}
	
	public static Person method2() {
		Person p = new Person("张三");
		try {
			return p;
		}finally {
			p.setName("李四");
		}
//		p.setName("王五");
//		return p;
	}
	
	public static int method3() {
		int i = 1;
		try {
			return i;
		}finally {
			i=2;
		}
//		p.setName("王五");
//		return p;
	}

}
