package jython;

import java.io.StringWriter;

import org.python.util.PythonInterpreter;

public class Ex04_gugu {
	public static void main(String[] args) {
		PythonInterpreter python = new PythonInterpreter();
		// 출력 방향을 자바 콘솔로 지정
		StringWriter out = new StringWriter();
		python.setOut(out);
		// 파이썬 스크립트 파일(gugu.py)의 변수 dan에 값을 전달
		python.set("dan", 7);
		python.execfile("C:/work/gugu.py");
		
		String result = out.toString();
		System.out.println(result);
		python.close();
	}
}
