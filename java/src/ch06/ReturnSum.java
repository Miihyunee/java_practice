package ch06;

public class ReturnSum {
	static int sum(int a) {
		int result = 0; //합계를 저장할 변수
		for (int i = 0; i <= a; i++) {
			result = result + i;
		}
		return result;
	}

	public static void main(String[] args) {
		int n = sum(50);
		System.out.println(n);
		n = sum(100);
		System.out.println(n);
	}
}
