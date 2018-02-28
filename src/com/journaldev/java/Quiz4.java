package com.journaldev.java;

interface Foo{
	int x = 10;
}
 
public class Quiz4 {
 
	public static void main(String[] args) {
		Foo.x = 20;
		System.out.println(Foo.x);
		
	}
 
}

//What will happen if we try to compile and run below program?
//		Prints 10
//		  Prints 20
//		  Compile Time Error
//		  Runtime error because Foo.x is final.
//		Incorrect	
//		By default any field of interface is public, static and final. So we can¡¯t change is, hence compile time error at line 8 statement Foo.x = 20;.