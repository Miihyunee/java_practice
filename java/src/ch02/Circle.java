package ch02;

import java.util.Scanner;

public class Circle {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.print("반지름을 입력하세요:");
			
		double r = sc.nextDouble(); //실수형 입력
		double length = 2 * Math.PI * r; // Math : 수학계산에 필요한 함수들이 들어있음
		double area = Math.PI * r * r;
		
		System.out.println("반지름:" + r);
		System.out.println("둘레:" + String.format("%5.2f", length)); // %전체자리수.소수이하
		System.out.println("넓이:" + String.format("%5.2f", area));
	}
}