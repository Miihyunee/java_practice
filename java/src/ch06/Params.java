package ch06;

public class Params {
	static int plus(int a, int b) {
		return a + b;
	}

	static int minus(int a, int b) {
		return a - b;
	}

	static int multi(int a, int b) {
		return a * b;
	}

	static int divide(int a, int b) {
		return a / b;
	}

	public static void main(String[] args) {
		int n = plus(10, 20);
		System.out.println(n);
		n = minus(100, 50);
		System.out.println(n);
		n = multi(10, 5);
		System.out.println(n);
		n = divide(10, 5);
		System.out.println(n);
	}
}
