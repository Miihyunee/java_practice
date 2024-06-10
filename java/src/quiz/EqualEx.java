package quiz;

import java.util.Scanner;

public class EqualEx {
	public static void main(String[] args) {
		String a = "hello";
		Scanner sc = new Scanner(System.in);
		System.out.print("입력하세요: ");
		String b = sc.next();
		System.out.println(a == b); // 주소값을 비교
		System.out.println(a.equals(b)); // 내용을 비교
	}
}
