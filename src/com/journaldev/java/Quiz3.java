package com.journaldev.java;



public class Quiz3 {
 
	public static String toString(){
		System.out.println("Test toString called");
		return "";
	}
	
	public static void main(String args[]){
		System.out.println(toString());
	}
}
//What will be the output of below program?
//		"Test toString called"
//		  "Test@7fh2bd8" (Object class toString() method is being called)
//		  Compile time error
//		Incorrect	
//		We will get compile time error because we can¡¯t have an Object class method overridden with static keyword. Note that Object class has toString() method. You will get compile time error as ¡°This static method cannot hide the instance method from Object¡±.