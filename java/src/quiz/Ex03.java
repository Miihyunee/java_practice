package quiz;

import java.util.Scanner;

public class Ex03 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("거리를 입력하세요(km):");
		double km = sc.nextDouble();
		double m = km * 1000;
		int fee = 0;

		if (m <= 2000) { //2km까지는 기본요금
			fee = 4800;
		} else {// 2km 초과 시 1.6km를 넘어가면 131m 마다 100원 부과
			double temp = m - 1600;
			fee = 4800 + (((int) Math.ceil(temp / 131.0)) * 100);
		}
		System.out.println("요금:" + fee);
	}
}