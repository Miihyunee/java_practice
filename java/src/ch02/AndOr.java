package ch02;

public class AndOr {
	public static void main(String[] args) {
		int a = 27;
		System.out.println(a >= 20 && a < 30);
		System.out.println(a >= 20 || a < 30);

		int b = 37;
		System.out.println(b >= 20 && b < 30);
		System.out.println(b >= 20 || b < 30);
		
		//A && B : A and B → 모두 true이어야 true
		//A || B : A or B → 하나라도 true면 true
	}
}