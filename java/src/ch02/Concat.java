package ch02;

public class Concat {
	public static void main(String[] args) {
		String a = "Hello " + "java";
		System.out.println(a);

		String b = "point:" + 100;
		System.out.println(b);

		String c = "95";
		System.out.println(Integer.parseInt(c) * 100);
		//Integer.parseInt : 정수클래스.정수를 뽑아내기
	}
}