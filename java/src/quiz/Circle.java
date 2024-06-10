package quiz;

import java.util.Scanner;

public class Circle {
	static double length(double r) {
		return 2 * Math.PI * r;
	}

	static double area(double r) {
		return Math.PI * r * r;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("반지름을 입력하세요 : ");
		double r = sc.nextDouble();
		//double r = 10.5;
		double a = length(r);
		double b = area(r);
		System.out.println("둘레는 " + String.format("%.2f", a));
		System.out.println("면적은 " + String.format("%.2f", b));
	}
}
