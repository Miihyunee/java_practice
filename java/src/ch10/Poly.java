package ch10;

class A {
	int n = 10;

	public void print() {
		System.out.println("B : " + n);
	}
}

class B extends A {
	int n = 20;

	@Override
	public void print() {
		System.out.println("B : " + n);
	}

	public void print2() {
		System.out.println("B : " + n * n);
	}
}

public class Poly {
	public static void main(String[] args) {
		B b = new B();
		b.print();
		b.print2();

		// A 자료형 = new B 자료형 - 상위 클래스 = new 하위클래스 로 할 경우에만 좌변우변이 다를 수 있다
		A a = new B();
		System.out.println(a.n);
		a.print();
	}
}
