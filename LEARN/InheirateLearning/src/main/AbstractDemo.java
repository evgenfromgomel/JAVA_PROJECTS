package main;

abstract class Square {
	abstract int squareIt(); // абстрактный метод
	int i;

	public void show() {
		System.out.println("обычный метод");
	}
}

// squ ен быть areIt() долж реализован подклассомSquare
class SquareReal extends Square {
	public int squareIt() {
		i = 5;
		return i * i;
	}
}

public class AbstractDemo {
	public static void main(String[] args) {
		// Square ob1 = new Square(); нельзя создать объект!
		Square ob2 = new SquareReal();
		System.out.println("10 в квадрате равно" + ob2.squareIt());
		ob2.show();
	}
}
