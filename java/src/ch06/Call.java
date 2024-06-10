package ch06;

public class Call {
	static void test1(int b) {
		System.out.println(b);
	}

	static void test2(int n[]) {
		for (int i = 0; i < n.length; i++) {
			System.out.print(n[i] + "\t");
		}
	}

	public static void main(String[] args) {
		int a = 10;
		test1(a);
		int[] nums = { 10, 20, 30, 40, 50 };
		test2(nums);
	}
}
