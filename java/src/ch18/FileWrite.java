package ch18;

import java.io.FileOutputStream;
import java.io.OutputStream;

public class FileWrite {
	public static void main(String[] args) {
		// OutputStream : 프로그램 → 파일
		OutputStream os = null;// 초기화
		try {
			// FileOutputStream : 파일에 내용 저장
			os = new FileOutputStream("c:/data/text.txt");
			System.out.println("Input:");
			while (true) {// 무한반복
				int ch = System.in.read();// 1byte 읽기
				System.out.println(ch + "==>" + (char) ch);
				if (ch == 13)// 줄바꿈
					break;// 종료
				os.write(ch);// 참조변수.기록(입력값)
			}
			System.out.println("done");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
