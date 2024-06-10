package ch18;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BufferedReaderEx {
	public static void main(String[] args) {
		// Buffer 임시메모리, BufferedReader 버퍼를 이용한 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Input: ");
		try {
			String str = br.readLine();// 한 라인 읽기
			System.out.println(str);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
