package quiz;

import java.util.Scanner;

public class Ex01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("이름:");
		String name = sc.next();
		System.out.print("출생연도:");
		int year = sc.nextInt();
		int age = 2023 - year;

		System.out.println(name + "님의 나이는 만 " + age + "세 입니다.");
	}
}