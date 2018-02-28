package com.journaldev.java;

import java.io.IOException;

public class Quiz1 {

	public static void main(String[] args) {
		try {
			throw new Exception("Hello ");
		}catch(Exception e) {
			System.out.print(e.getMessage());
		} catch(IOException e) {
			System.out.print(e.getMessage());
		} finally {
			System.out.println("World");
		}
	}
}

//What will be the output of below program?
//		 Hello Hello World
//		  Hello World
//		  Hello
//		  Compile time error
//		Incorrect	
//		Compile time error Unreachable catch block for IOException. It is already handled by the catch block for Exception.
