package quiz;

public class Ex04 {
	public static void main(String[] args) {
		int num = 10;
		for (int i = 1; i <= num; i++) {
			if (i % 2 == 0) {
				System.out.println(i + " → 짝수");
			} else {
				System.out.println(i + " → 홀수");
			}
		}
	}
}