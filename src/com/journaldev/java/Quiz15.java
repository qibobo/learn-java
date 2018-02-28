package com.journaldev.java;

public class Quiz15 {

	public static void main(String[] args) {
		String x = "abc";
		String y = "abc";
		x.concat(y);
		System.out.print(x);
	}
}

//null
//abcabc
//abc
//Correct	
//x.concat(y); will create a new string but it¡¯s not assigned to x, so value of x is not changed.