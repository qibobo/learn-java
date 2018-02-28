package com.journaldev.java;

public class Quiz9 {
	 
	public static void main(String[] args) {
		Subclass s1 = new Subclass();
		s1.foo();
		
		Super s = new Subclass();
		s.foo();
	}
}
 
class Super {
	private void foo() {
		System.out.println("Super");
	}
}
 
class Subclass extends Super {
	public void foo() {
		System.out.println("Subclass");
	}
}

//Compile time error at both line 7 and 10
//Compile time error at line 10
//Compile time error at line 7
//Works fine and prints "Subclass" two times
//Correct	
//Compile time error at line 10 because Super class foo() method is private. Error will be The method foo() from the type Super is not visible.