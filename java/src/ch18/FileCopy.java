package ch18;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class FileCopy {
	public static void main(String[] args) {
		String str = "";
		BufferedReader reader = null;
		BufferedWriter writer = null;
		String file1 = "c:/data/a.txt";
		String file2 = "c:/data/b.txt";
		try {
			reader = new BufferedReader(new FileReader(new File(file1)));
			writer = new BufferedWriter(new FileWriter(new File(file2)));
			while (true) {// 무한반복
				str = reader.readLine();// 한 줄 읽기
				if (str == null)// null 확인
					break;// 종료
				writer.write(str + "\r\n"); // \r (carriage return) : 커서를 현재 라인의 맨앞으로 이동
			}
			System.out.println("done");
			reader.close();
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
