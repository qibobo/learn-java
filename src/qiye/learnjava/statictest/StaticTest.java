package qiye.learnjava.statictest;

public class StaticTest {
//交换两个代码块的位置测试，java会按顺序执行静态代码块然后赋值
	//块2
		static{
			i=100;
		}
	//块1
	public static int i= 0;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(i);
	}

}
