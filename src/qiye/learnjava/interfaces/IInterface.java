package qiye.learnjava.interfaces;

public interface IInterface {
	//接口种所有的方法自动为public也只能是public
	protected void out();
	void out(String str);
	public void out2();
	//接口中可以定义“成员变量”，或者说是不可变的常量，
	//因为接口中的“成员变量”会自动变为为public static final。
	//可以通过类命名直接访问：ImplementClass.name
	int value = 0;
	public static final int value2 = 1;
}
