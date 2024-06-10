package ch05;

public class IntArray {
	public static void main(String[] args) {
		int[] nums = { 10, 20, 30, 40, 50, 60, 70, 80 };
//		int[] nums;
//		nums = new int[5];
//		nums[0] = 10;
//		nums[1] = 20;
//		nums[2] = 30;
//		nums[3] = 40;
//		nums[4] = 50;
		for (int i = 0; i < nums.length; i++) {
			System.out.println(nums[i]);
		}
		for (int n : nums) {
			System.out.println(n);
		}
	}
}
