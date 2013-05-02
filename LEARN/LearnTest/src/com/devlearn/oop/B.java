package com.devlearn.oop;

public class B extends A {
	static int x;
	
	static int getX(){
		System.out.println("In B class x = " + x);
		return x;
	}
}
