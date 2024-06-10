package ch04;

public class ContinueEx {
	public static void main(String[] args) {
		for (int i = 1; i <= 10; i++) {
			if (i % 5 == 0)
				continue;
			System.out.println(i);
		}
	}
}
