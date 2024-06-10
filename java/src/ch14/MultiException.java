package ch14;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MultiException {
	public static void main(String[] args) {
		int num = 50;
		Scanner sc = null;
		try {
			System.out.println("Number:");
			sc = new Scanner(System.in);
			int value = sc.nextInt();
			System.out.println(num / value);
		} catch (NullPointerException e) { // 참조변수, 내용X
			System.out.println("NullPointerException");
		} catch (ArithmeticException e) {// 산술연산
			System.out.println("ArithmeticException");
		} catch (InputMismatchException e) {// 자료형 불일치
			System.out.println("InputMismatchException");
		} catch (Exception e) {// 기타 예외이므로 마지막에 배치
			System.out.println("Other Exception");
		} finally {// 항상 실행됨, 필수 작성은 아님
			if (sc != null)
				sc.close();// 메모리 정리
		}
		System.out.println("end");
	}
}
