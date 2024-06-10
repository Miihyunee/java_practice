package jython;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex11_Iris {
	public static void main(String[] args) throws Exception {
		// 파이썬 소스 파일에 한글 주석이 있으면 실행이 안됨
		// 출력 결과에 한글이 있으면 깨짐
		// iris.py에 0.2라는 값을 전달하고 싶은 경우
		ProcessBuilder pb = new ProcessBuilder("python", "", "0.2");
		Process p = pb.start();
		BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream(), "utf-8"));
		try {
			String line = "";
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
		} finally {
			try {
				if(br != null) {
					br.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}