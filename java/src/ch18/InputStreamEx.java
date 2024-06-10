package ch18;

import java.io.IOException;

public class InputStreamEx {
	public static void main(String[] args) {
		int a = 0;
		try {// 시도
			System.out.println("Input: ");
			a = System.in.read();// 1byte씩 읽기
			while (a != 13) {// 13 = \n 개행문자, new line 줄바꿈
				System.out.println(a + "==>" + (char) a);
				a = System.in.read();
			}
		} catch (IOException e) {// 예외처리 클래스
			e.printStackTrace();
		}
	}
}
