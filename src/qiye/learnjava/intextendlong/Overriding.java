package qiye.learnjava.intextendlong;

public class Overriding {

//	public void funcLong(long l){
//		System.out.println("基本类型被调用" + l);
//	}
	public void funcLong(Long l){
		System.out.println("包装类型被调用" + l);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 20;
		Integer j = 20;
		Overriding o = new Overriding();
		o.funcLong(i);
		o.funcLong(Integer.valueOf(i));
		o.funcLong(j);
	}

}
