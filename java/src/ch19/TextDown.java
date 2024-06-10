package ch19;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class TextDown {
	public static void main(String[] args) {
		URL url = null;
		try {// 시도
			url = new URL("https://raw.githubusercontent.com/selva86/datasets/master/ozone.csv");
			// url 접속
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			if (conn != null) {// 접속
				conn.setConnectTimeout(3000);// 3초
				// getResponseCode : 응답코드
				// HTTP_OK : 200, NOT_FOUND : 404
				if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
					//
					BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
					BufferedWriter bw = new BufferedWriter(new FileWriter(new File("c:/data/ozone.csv")));
					while (true) {// 무한반복
						String line = br.readLine();// 한 줄 읽기
						if (line == null) // 더이상 내용 없음
							break;// 반복문 종료
						bw.write(line + "\r\n"); // 저장
					}
					br.close();
					bw.close();
					System.out.println("완료되었습니다.");
				}
				conn.disconnect();// 접속해제
			}
		} catch (Exception e) {// 예외발생 시
			e.printStackTrace();
		}
	}
}
