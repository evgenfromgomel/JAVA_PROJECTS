package main;

interface Shape {
	double PI = Math.PI;
	int i = 5;

	double getSquare(); // ���������� �������

	void showParameters();
}


class Rectangle implements Shape {

	double a, b;

	Rectangle(double a, double b) {
		this.a = a;
		this.b = b;
	}

	public double getSquare() {
		return a * b;
	}

	public void showParameters() {
		System.out.println("�������: a=" + a + " b=" + b);
	}

}

class Circle implements Shape {
	double r;
	

	Circle(double r) {
		this.r = r;
	}

	public double getSquare() {
		return 2 * PI * r * r;
	}

	public void showParameters() {
		System.out.println("������: r=" + r + " " + Shape.i);
	}
}

abstract class Triangle implements Shape {
	double a, b, angle;

	Triangle(double a, double b, double angle) {
		this.a = a;
		this.b = b;
		this.angle = angle;
	}

	public void showParameters() {
		System.out.println("�������: a=" + a + " b=" + b);
		System.out.println("���� ����� ����angle=" + angle);
	}
}

public class InterfaceDemo {
	public static void main(String[] args) {
		Rectangle r = new Rectangle(5, 9.95);
		Circle c = new Circle(7.01);
		printFeatures(r);
		printFeatures(c);
	}

	public static void printFeatures(Shape f) {
		System.out.println("�������:" + f.getSquare()
				+ " \n ��������� ������- >");
		f.showParameters();
	}
}
