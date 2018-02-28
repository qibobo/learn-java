package com.journaldev.java;

public class Quiz8 {

	public static void main(String[] args) {
		Super s = new Subclass();
		s.foo();
	}
}

class Super {
	void foo() {
		System.out.println("Super");
	}
}

class Subclass extends Super {
	static void foo() {
		System.out.println("Subclass");
	}

}

//Compile time error
//Subclass
//Super
//Runtime error
//Correct	
//Subclass foo() method can¡¯t be static, it will give compile time error This static method cannot hide the instance method from Super.