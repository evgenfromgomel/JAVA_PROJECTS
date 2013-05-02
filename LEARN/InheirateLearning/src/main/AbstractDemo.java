package main;

abstract class Square {
	abstract int squareIt(); // ����������� �����
	int i;

	public void show() {
		System.out.println("������� �����");
	}
}

// squ �� ���� areIt() ���� ���������� ����������Square
class SquareReal extends Square {
	public int squareIt() {
		i = 5;
		return i * i;
	}
}

public class AbstractDemo {
	public static void main(String[] args) {
		// Square ob1 = new Square(); ������ ������� ������!
		Square ob2 = new SquareReal();
		System.out.println("10 � �������� �����" + ob2.squareIt());
		ob2.show();
	}
}
