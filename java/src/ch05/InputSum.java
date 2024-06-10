package ch05;

import java.util.Scanner;

public class InputSum {
	public static void main(String[] args) {
		int nums[] = new int[5];
		int sum = 0;
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < nums.length; i++) {
			System.out.print("Number " + (i + 1) + ": ");
			nums[i] = sc.nextInt();
			sum = sum + nums[i];
		}
		System.out.println("Sum: " + sum);
		// sc.close(); 메모리 손실을 막기 위해 닫기(그러나 Scanner 는 안닫는게 좋음)
	}
}
