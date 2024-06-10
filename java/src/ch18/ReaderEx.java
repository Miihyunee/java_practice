package ch18;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class ReaderEx {
	public static void main(String[] args) {
		int var = 0;
		// InputStream (바이트 단위) / InputStreamReader(문자 단위)
		// 자료형이 다르면 좌변이 상위 자료형
		Reader input = new InputStreamReader(System.in);
		System.out.println("Input: ");
		try {// 입력
			while (true) {// 무한반복
				var = input.read();// 한글자 읽기
				if (var == 13)// 13 == 줄바꿈 문자
					break;
				System.out.println(var + "==>" + (char) var);
			}
		} catch (IOException e) {// 예외처리
			e.printStackTrace();
		}
	}
}
