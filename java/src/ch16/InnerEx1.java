package ch16;

//컴파일 시, InnerEx1.class, InnerEx1$Inner.class 가 만들어짐 (외부클래스$내부클래스.class)

public class InnerEx1 {
	static int x = 10; // static : 바로 사용 가능, no -static : new 이후 사용 가능

	class Inner {// 내부 클래스
		int getX() {
			return x;
		}
	}

	public static void main(String[] args) {
		System.out.println(x);
		InnerEx1 e = new InnerEx1();
		InnerEx1.Inner in = e.new Inner();
		System.out.println(in.getX());
	}
}
