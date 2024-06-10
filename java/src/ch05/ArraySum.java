package ch05;

public class ArraySum {
	public static void main(String[] args) {
		int[] nums = { 10, 20, 30, 40, 50 };
		System.out.println(nums);
		System.out.println(nums[0]);
		System.out.println(nums[1]);
		System.out.println(nums[4]);
		// System.out.println(nums[5);
		nums[2] = 300;
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum = sum + nums[i];
		}
		System.out.println(sum);
	}
}
