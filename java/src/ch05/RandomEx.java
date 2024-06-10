package ch05;

import java.util.Random;

public class RandomEx {
	public static void main(String[] args) {
		Random rand = new Random();
		int[] nums = new int[10];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = rand.nextInt(100) + 1;
			System.out.println(nums[i]);
		}
	}
}
