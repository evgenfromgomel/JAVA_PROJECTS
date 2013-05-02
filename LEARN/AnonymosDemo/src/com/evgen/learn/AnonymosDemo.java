package com.evgen.learn;

import java.io.Serializable;

	class ABC{
		int showInt(){
			return 5;
		}
	}
	
	interface I1 extends Iterable<String>, Cloneable, Serializable {
		
	}

	
	class Inh{
		public void getX(){	}
	}
	
	class ExInh extends Inh{
		public void getX(int x){
			
		}
	}

	class AB extends A{	
		
		@Override
		public int getNum() {
			// TODO Auto-generated method stub
			return 0;
		}
		
	}
	abstract class A {
	private char c = 'A';

	A() {
	}

	A(char c) {
		this.c = c;
	}

	public char getC() {
		return c;
	}

	public abstract int getNum();
}

class AnonymousDemo {
	static int j = 2;
	
	static A ob1 = new A((char) 57) {
		// A(char c) {ch = c + 1;}
		// ошибка!  онструктор переопредел€ть нельз€
		{
			System.out.println("первый анонимный класс");
		}

		public int getNum() {
			return Character.digit(getC(), 10);
		}
	};

	public static void main(String[] args) {
		System.out.println(ob1.getNum());
		String str;
		new ABC(){
			{
				System.out.println("string"); 
			}
		};
		A ob2 = new A() {
			int i = 1;
			{
				System.out.println("второй анонимный класс");
			}

			public int getNum() {
				i = show(); // вызов собственного метода
				return i + Character.getNumericValue(getC());
			}

			int show() {
				return i + j;
			}
		};
		
		System.out.println(ob2.getNum());
	}
}