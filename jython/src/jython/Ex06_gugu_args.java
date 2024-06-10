package jython;

import java.io.StringWriter;
import java.util.Scanner;

import org.python.util.PythonInterpreter;

public class Ex06_gugu_args {
	public static void main(String[] args) {
		System.out.println("input : ");
		Scanner sc = new Scanner(System.in);
		int dan = sc.nextInt(); // 키보드 입력값을 정수로 변환
		String[] arguments = { "gugu_args.py", dan + "" }; // 스트링 타입으로 하기 위해 → dan + ""
		PythonInterpreter.initialize(System.getProperties(), System.getProperties(), arguments);
		PythonInterpreter python = new PythonInterpreter();
		StringWriter out = new StringWriter();
		python.setOut(out);
		python.execfile("C:/work/gugu_args.py");
		String result = out.toString();
		System.out.println(result);
		python.close();
	}
}
