package com.journaldev.java;

public class Quiz13 {

	public static void main(String[] args) {
		
		char c = 65;
		System.out.println("c = "+c);
	}

}

//Runtime error
//Prints "c = 65"
//Prints "c = A"
//Compile Time Error
//Correct	
//Java compiler tries to automatically convert int to char. Since 65 gets converted to A, hence output will be ¡°c = A¡±. Note that char are limited to values from \u0000 to \uffff. So char c = 65535; is valid but char c = 65536; will give compile time error.