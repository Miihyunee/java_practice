package ch12;

public class Wrapper {
	public static void main(String[] args) {
		// 클래스
		Integer i1 = 10;
		int num1 = i1.intValue();
		int num2 = 20;
		int sum = num1 + num2;
		System.out.println(sum);
		// toBinaryString : 10진수를 2진수로 변경
		System.out.println(Integer.toBinaryString(sum));
		// parseInt : 정수를 추출
		System.out.println(Integer.parseInt("100"));
		// toString : 정수를 String으로 변경
		System.out.println(Integer.toString(100));
		System.out.println(100 + "");

	}
}
