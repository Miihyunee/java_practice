package ch14;

public class ExceptionEx1 {
	public static void main(String[] args) {
		int a = 10, b = 0, c;
		c = a / b;// 0으로 나누었기 때문
		System.out.println(c);
		System.out.println("end");
	}
}

//ArithmeticException: 산술연산관련 예외