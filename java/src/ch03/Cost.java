package ch03;

import java.util.Scanner;

public class Cost {
	public static void main(String[] args) {
		int point_use = 0;
		int fee = 0;
		int pay = 0;
		Scanner sc = new Scanner(System.in);
		System.out.print("이름을 입력하세요:");
		String name = sc.next();
		System.out.print("가격을 입력하세요:");
		int price = sc.nextInt();
		System.out.print("포인트를 입력하세요:");
		int point = sc.nextInt();
		if (price < 20000) {
			fee = 2000;
		}
		if (point >= 10000) {
			if (point > price) {
				point_use = price;
			} else {
				point_use = point;
			}
			pay = price + fee - point;
		} else {
			pay = price + fee;
		}
		System.out.println("이름: " + name);
		System.out.println("가격: " + price);
		System.out.println("배송료: " + fee);
		System.out.println("포인트 사용: " + point_use);
		System.out.println("금액: " + String.format("%,d", pay));
	}
}
