package ch05;

public class Array2D {
	public static void main(String[] args) {
		int[][] nums = { { 10, 20, 30 }, { 40, 50, 60 }, { 70, 80, 90 } };
//		int[][] nums = new int[3][3];
//		nums[0][0] = 10;
//		nums[0][1] = 20;
//		nums[0][2] = 30;
//		nums[1][0] = 40;
//		nums[1][1] = 50;
//		nums[1][2] = 60;
//		nums[2][0] = 70;
//		nums[2][1] = 80;
//		nums[2][2] = 90;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.println(nums[i][j]);
			}
		}
	}
}
