package com.journaldev.java;

import java.io.IOException;

public class Quiz5 {

	public static void main(String[] args) {
		try {
			throw new IOException("Hello");
		}catch(IOException | Exception e) {
			System.out.println(e.getMessage());
		}
	}
}

//Prints "Hello"
//Runtime error
//Compile time error
//Correct	
//Compile time error as The exception IOException is already caught by the alternative Exception
//
//Read Java Catch multiple exceptions
