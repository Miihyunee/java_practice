package jython;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex10_Ozone {

	// jython에서는 아직 numpy, pandas 등의 외부 라이브러리를 직접 호출할 수 없고 CPython 또는 JyNI 등의 툴을 이용해야 한다.
	// 따라서 데이터 분석 등의 경우와 같이 외부 라이브러리의 호출이 필요한 경우에는 Java에 내장된 Process 호출 기능을 사용한다.
	public static void main(String[] args) throws Exception {
		// 파이썬 소스 파일에 한글 주석이 있으면 실행이 안됨
		// 출력 결과에 한글이 있으면 깨짐
		ProcessBuilder pb = new ProcessBuilder("python", "c:/work/ozone.py");
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