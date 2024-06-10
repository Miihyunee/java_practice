package ch02;

import java.util.Scanner;

public class Point {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("이름을 입력하세요:");
		String name = sc.next();
		System.out.print("Java 점수:");
		int java = sc.nextInt();
		System.out.print("DB 점수:");
		int db = sc.nextInt();
		System.out.print("Math 점수:");
		int math = sc.nextInt();
		int tot = java + db + math;
		double avg = tot / 3.0;
		System.out.println("이름:" + name);
		System.out.println("Java:" + java);
		System.out.println("DB:" + db);
		System.out.println("Math:" + math);
		System.out.println("Tot:" + tot);
		System.out.println("Avg:" + String.format("%5.1f", avg));
	}
}